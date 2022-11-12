package cz.mateusz.jongo.practice.database.collections;

import com.mongodb.DB;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.util.Optional;

public abstract class JongoCollection<T, ID> implements Collection<T, ID> {

    private String collectionName;

    protected MongoCollection collection;

    protected LastKeyCollection keyCollection;

    protected JongoCollection(String collectionName, DB database) {
        this.collectionName = collectionName;
        this.collection = new Jongo(database).getCollection(collectionName);
    }

    public String getCollectionName() {
        return collectionName;
    }

    protected final LastKey createNextKey() {
        Optional<LastKey> possibleCurrentKey = keyCollection.findById(getCollectionName());

        LastKey nextKey = null;

        if(possibleCurrentKey.isPresent()) {
            LastKey currentKey = possibleCurrentKey.get();
            nextKey = currentKey.increment(10L);
        }

        if(nextKey == null) nextKey = LastKey.create(getCollectionName(), 10L);

        return nextKey;
    }
}
