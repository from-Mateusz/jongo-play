package cz.mateusz.jongo.practice.database.collections;

import com.mongodb.DB;
import cz.mateusz.jongo.practice.database.ConnectedDatabaseWrapper;

import java.util.List;
import java.util.Optional;

public class LastKeyCollection extends JongoCollection<LastKey, String> {

    public LastKeyCollection() {
        super("lastkeys", ConnectedDatabaseWrapper.unwrap());
    }

    public LastKeyCollection(String name, DB database) {
        super(name, database);
    }

    @Override
    public List<LastKey> findAll() {
        return null;
    }

    @Override
    public Optional<LastKey> findById(String s) {
        return Optional.empty();
    }

    @Override
    public LastKey save(LastKey lastKey) {
        return null;
    }

    @Override
    public LastKey remove(LastKey lastKey) {
        return null;
    }
}
