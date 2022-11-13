package cz.mateusz.jongo.practice.database.collections;

import cz.mateusz.jongo.practice.database.EntityModel;
import org.jongo.MongoCollection;

import javax.swing.text.html.parser.Entity;

public class KeysCollection {

    private MongoCollection collection;

    public KeysCollection(final MongoCollection collection) {
        this.collection = collection;
    }

    public <T> EntityKey<T> nextKey(EntityModel entityModel) {
        EntityKey<T> key = this.collection.findOne("{ collection: " + collection + " }").as(EntityKey.class);
        return key;
    }

    public void saveKey(EntityKey entityKey) {
        this.collection.save(entityKey);
    }

    public void removeKeys() {
        this.collection.remove("{}");
    }
}
