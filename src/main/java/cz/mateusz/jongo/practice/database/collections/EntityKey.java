package cz.mateusz.jongo.practice.database.collections;

import org.jongo.marshall.jackson.oid.MongoId;

public class EntityKey<T> {

    @MongoId
    private String collection;

    private T value;

    public EntityKey() {}

    private EntityKey(String collection, T value) {
        this.collection = collection;
        this.value = value;
    }

    public static <T> EntityKey create(String collection, T value) {
        return new EntityKey(collection, value);
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public EntityKey increment(Long value) {
        return new EntityKey(collection, value);
    }
}
