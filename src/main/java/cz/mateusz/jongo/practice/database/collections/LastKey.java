package cz.mateusz.jongo.practice.database.collections;

import org.jongo.marshall.jackson.oid.MongoId;

public class LastKey {

    @MongoId
    private String collection;

    private Long value;

    public LastKey() {}

    private LastKey(String collection, Long value) {
        this.collection = collection;
        this.value = value;
    }

    public static LastKey create(String collection, Long value) {
        return new LastKey(collection, value);
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public LastKey increment(Long value) {
        return new LastKey(collection, value);
    }
}
