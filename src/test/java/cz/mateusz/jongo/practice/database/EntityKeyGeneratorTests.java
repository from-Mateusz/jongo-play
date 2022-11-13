package cz.mateusz.jongo.practice.database;

import cz.mateusz.jongo.practice.database.collections.KeysCollection;
import cz.mateusz.jongo.practice.models.Fighter;
import cz.mateusz.jongo.practice.models.FullName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class EntityKeyGeneratorTests {

    private EntityKeyManager entityKeyManager;

    @BeforeEach
    public void setupEnvironment() {
        MongoDatabase mongoDatabase = MongoDatabase.getInstance();
        KeysCollection keysCollection = new KeysCollection(mongoDatabase.getCollection("keys"));
        this.entityKeyManager = new DefaultEntityKeyGenerator(keysCollection);
    }

    @Test
    public void shouldGenerateNextKeyForTheFighterEntity() {
        Fighter fighter = new Fighter(new Fighter.FighterCreator(FullName.create("Mateusz", "Czyzewski"), "mmmm"));
        Long key = (Long) entityKeyManager.generateNextKeyFor(fighter);
        assertThat(key, notNullValue());
    }

    @AfterEach
    public void clearEnvironment() {
        this.entityKeyManager.clearKeys();
        this.entityKeyManager = null;
    }
}
