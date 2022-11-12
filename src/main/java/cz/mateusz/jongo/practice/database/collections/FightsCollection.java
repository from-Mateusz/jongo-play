package cz.mateusz.jongo.practice.database.collections;

import com.mongodb.DB;
import cz.mateusz.jongo.practice.database.ConnectedDatabaseWrapper;
import cz.mateusz.jongo.practice.models.Fight;
import org.jongo.MongoCursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FightsCollection extends JongoCollection<Fight, Long> {
    public FightsCollection() {
        super("fights", ConnectedDatabaseWrapper.unwrap());
    }

    public FightsCollection(String name, DB database) {
        super(name, database);
    }

    @Override
    public List<Fight> findAll() {
        MongoCursor<Fight> results = collection.find().as(Fight.class);
        List<Fight> fights = new ArrayList<>();
        results.iterator().forEachRemaining(fights::add);
        return fights;
    }

    @Override
    public Optional<Fight> findById(Long id) {
        Fight fight = collection.findOne("{ _id: " + id + " }" ).as(Fight.class);
        return Optional.ofNullable(fight);
    }

    @Override
    public Fight save(Fight fight) {

        LastKey nextKey = createNextKey();

        fight.setId(nextKey.getValue());

        collection.insert(fight);

        keyCollection.save(nextKey);

        return fight;
    }

    @Override
    public Fight remove(Fight fight) {
        collection.remove("{ _id: " + fight.getId() + " }");
        return fight;
    }
}
