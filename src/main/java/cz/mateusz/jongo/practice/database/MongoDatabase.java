package cz.mateusz.jongo.practice.database;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public final class MongoDatabase {

    private final static MongoDatabase INSTANCE = new MongoDatabase("fighters");

    private DB db;

    private MongoDatabase(String name) {
        this.db = new MongoClient().getDB(name);
    }

    public static MongoDatabase getInstance() {
        return INSTANCE;
    }

    public MongoCollection getCollection(String name) {
        return new Jongo(db).getCollection(name);
    }
}
