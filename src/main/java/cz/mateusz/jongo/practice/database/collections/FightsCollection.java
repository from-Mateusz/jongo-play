package cz.mateusz.jongo.practice.database.collections;

import cz.mateusz.jongo.practice.database.MongoDatabase;
import cz.mateusz.jongo.practice.models.Fight;
import org.jongo.MongoCursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FightsCollection extends JongoCollection<Fight, Long> {

    public FightsCollection(MongoDatabase database) {
        super(database, "fights");
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
        return null;
    }

    @Override
    public Fight remove(Fight fight) {
        collection.remove("{ _id: " + fight.getId() + " }");
        return fight;
    }
}
