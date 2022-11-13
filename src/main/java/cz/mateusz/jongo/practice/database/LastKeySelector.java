package cz.mateusz.jongo.practice.database;

import cz.mateusz.jongo.practice.database.collections.JongoCollection;
import cz.mateusz.jongo.practice.database.collections.EntityKey;

import java.util.Optional;

public interface LastKeySelector {
    Optional<EntityKey> selectNextKey(JongoCollection collection);
}
