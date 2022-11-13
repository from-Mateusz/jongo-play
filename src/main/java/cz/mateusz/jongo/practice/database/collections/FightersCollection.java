package cz.mateusz.jongo.practice.database.collections;

import cz.mateusz.jongo.practice.database.DefaultEntityKeyGenerator;
import cz.mateusz.jongo.practice.database.EntityKeyManager;
import cz.mateusz.jongo.practice.database.MongoDatabase;
import cz.mateusz.jongo.practice.models.Fighter;
import org.jongo.MongoCursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FightersCollection extends JongoCollection<Fighter, Long> {

    private EntityKeyManager entityKeyManager;

    public FightersCollection(MongoDatabase database) {
        super(database, "fighters");
//        this.entityKeyManager = new DefaultEntityKeyGenerator();
    }

    @Override
    public List<Fighter> findAll() {
        MongoCursor<Fighter> results = collection.find().as(Fighter.class);
        List<Fighter> fighters = new ArrayList<>();
        results.iterator().forEachRemaining(fighters::add);
        return fighters;
    }

    @Override
    public Optional<Fighter> findById(Long id) {
        Fighter fighter = collection.findOne("{ _id: " + id + " }").as(Fighter.class);
        return Optional.ofNullable(fighter);
    }

    @Override
    public Fighter save(Fighter fighter) {

        Long nextKey = (Long) entityKeyManager.generateNextKeyFor(fighter);

        fighter.setId(nextKey);

        collection.insert(fighter);

        return fighter;
    }

    @Override
    public Fighter remove(Fighter fighter) {
        collection.remove("{ _id: " + fighter.getId() + " }");
        return fighter;
    }
}
