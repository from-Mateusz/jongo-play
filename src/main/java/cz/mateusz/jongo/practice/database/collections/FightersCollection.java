package cz.mateusz.jongo.practice.database.collections;

import com.mongodb.DB;
import cz.mateusz.jongo.practice.database.ConnectedDatabaseWrapper;
import cz.mateusz.jongo.practice.models.Fighter;
import org.jongo.MongoCursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FightersCollection extends JongoCollection<Fighter, Long> {

    public FightersCollection() {
        super("fighters", ConnectedDatabaseWrapper.unwrap());
    }

    public FightersCollection(String name, DB database) {
        super(name, database);
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

        LastKey nextKey = createNextKey();

        fighter.setId(nextKey.getValue());

        collection.insert(fighter);

        keyCollection.save(nextKey);

        return fighter;
    }

    @Override
    public Fighter remove(Fighter fighter) {
        collection.remove("{ _id: " + fighter.getId() + " }");
        return fighter;
    }
}
