package cz.mateusz.jongo.practice.database;

import cz.mateusz.jongo.practice.database.collections.EntityKey;

public interface EntityKeyManager {
    <T extends EntityModel> Object generateNextKeyFor(T entityModel);
    void saveGeneratedKey(EntityKey entityKey);
    void clearKeys();
}
