package cz.mateusz.jongo.practice.collections;

import com.mongodb.DB;
import cz.mateusz.jongo.practice.models.Fighter;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.ArrayList;
import java.util.List;

public class FightersCollection {

    private MongoCollection collection;

    public FightersCollection(DB database) {
        this.collection = new Jongo(database).getCollection("fighters");
    }

    public List<Fighter> findAll() {
        MongoCursor<Fighter> results = collection.find("{}").as(Fighter.class);
        List<Fighter> fighters = new ArrayList<>();
        fighters.iterator().forEachRemaining(fighters::add);
        return fighters;
    }
}
