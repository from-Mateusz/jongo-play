package cz.mateusz.jongo.practice.database;

import cz.mateusz.jongo.practice.database.annotations.MongoDocument;
import cz.mateusz.jongo.practice.database.annotations.MongoDocumentEntityIdType;
import cz.mateusz.jongo.practice.database.collections.EntityKey;
import cz.mateusz.jongo.practice.database.collections.KeysCollection;

import java.lang.annotation.Annotation;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public class DefaultEntityKeyGenerator implements EntityKeyManager {

    private final static SecureRandom random = new SecureRandom();

    private KeysCollection keysCollection;

    public DefaultEntityKeyGenerator(KeysCollection keysCollection) {
        this.keysCollection = keysCollection;
    }

    @Override
    public <T extends EntityModel> Object generateNextKeyFor(T entityModel) {
        EntityKey currentKey = keysCollection.nextKey(entityModel);
        EntityKey nextKey = null;
        Optional<Annotation> possibleMongoDocumentData = Arrays.stream(entityModel.getClass().getAnnotations())
                                                                .filter(annotation -> annotation.annotationType().isAssignableFrom(MongoDocument.class))
                                                                .findFirst();
        if(possibleMongoDocumentData.isPresent()) {
            MongoDocument mongoDocument = (MongoDocument) possibleMongoDocumentData.get();

            if(mongoDocument.idType() == MongoDocumentEntityIdType.LONG) {
                nextKey = EntityKey.<Long>create(mongoDocument.collectionName(),
                        currentKey == null ? 10L : ((Long) (currentKey.getValue())) + 10);
            }
            if(mongoDocument.idType() == MongoDocumentEntityIdType.STRING) {
                byte[] keyBytes = new byte[16];
                random.nextBytes(keyBytes);
                nextKey = EntityKey.<String>create(mongoDocument.collectionName(), Base64.getEncoder().encodeToString(keyBytes));
            }
        }
        saveGeneratedKey(nextKey);
        return nextKey.getValue();
    }

    @Override
    public void saveGeneratedKey(EntityKey entityKey) {
        keysCollection.saveKey(entityKey);
    }

    @Override
    public void clearKeys() {
        keysCollection.removeKeys();
    }
}
