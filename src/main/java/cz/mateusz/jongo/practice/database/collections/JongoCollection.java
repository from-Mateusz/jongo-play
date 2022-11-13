package cz.mateusz.jongo.practice.database.collections;

import cz.mateusz.jongo.practice.database.MongoDatabase;
import org.jongo.MongoCollection;

public abstract class JongoCollection<T, ID> implements Collection<T, ID> {

    private String name;

    protected MongoCollection collection;

    protected JongoCollection(MongoDatabase database, String name) {
        this.name = name;
        this.collection = database.getCollection(name);
    }

    public String getName() {
        return name;
    }
}
