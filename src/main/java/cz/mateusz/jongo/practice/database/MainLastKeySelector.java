package cz.mateusz.jongo.practice.database;

import cz.mateusz.jongo.practice.database.collections.LastKey;
import cz.mateusz.jongo.practice.database.collections.LastKeyCollection;

import java.util.Optional;

public class MainLastKeySelector implements LastKeySelector {

    private LastKeyCollection keyCollection;

    public MainLastKeySelector(LastKeyCollection keyCollection) {
        this.keyCollection = keyCollection;
    }

    @Override
    public Optional<LastKey> selectNextKey(String collection) {
        Optional<LastKey> possibleCurrentKey = keyCollection.findById(collection);
        LastKey nextKey = null;
        if(possibleCurrentKey.isPresent()) {
            LastKey currentKey = possibleCurrentKey.get();
            nextKey = currentKey.increment(10L);
        }
        return Optional.ofNullable(nextKey);
    }
}
