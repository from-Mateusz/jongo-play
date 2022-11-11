package cz.mateusz.jongo.practice;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;

/**
 * Unfortunately Jongo's API still bases on an obsolete Java Mongo Driver's version.
 * Nevertheless, it was a good project with a querying abstraction as close as possible
 * to Mongo's native format.
 */
public final class ConnectedDatabase {
    private static DB db = new MongoClient().getDB("fighters");

    private ConnectedDatabase() {}

    public static Jongo jongo() { return new Jongo((DB) ConnectedDatabase.db); }
}
