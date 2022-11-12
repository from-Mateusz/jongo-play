package cz.mateusz.jongo.practice.database;

import cz.mateusz.jongo.practice.database.collections.LastKey;

import java.util.Optional;

public interface LastKeySelector {
    Optional<LastKey> selectNextKey(String collection);
}
