package cz.mateusz.jongo.practice.database;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Unfortunately Jongo's API still bases upon an obsolete Java Mongo Driver's version.
 * Nevertheless, it was a good project with a querying abstraction as close as possible
 * to Mongo's native format.
 */
public final class ConnectedDatabaseWrapper {
    private static DB db = new MongoClient().getDB("fighting");

    private ConnectedDatabaseWrapper() {}

    public static DB unwrap() {
        return ConnectedDatabaseWrapper.db;
    }
}
