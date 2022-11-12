package cz.mateusz.jongo.practice.services;

import cz.mateusz.jongo.practice.database.collections.FightersCollection;
import cz.mateusz.jongo.practice.externals.FighterId;
import cz.mateusz.jongo.practice.models.Fighter;

import java.util.Optional;

public class MainFightersService implements FightersService {

    private FightersCollection fightersCollection;

    public MainFightersService(FightersCollection fightersCollection) {
        this.fightersCollection = fightersCollection;
    }

    @Override
    public FighterId register(Fighter fighter) {
        fightersCollection.save(fighter);
        return null;
    }

    @Override
    public Optional<Fighter> findFighterWithBestRecord() {
        return Optional.empty();
    }

    @Override
    public Optional<Fighter> findFighterWithWorstRecord() {
        return Optional.empty();
    }

    @Override
    public boolean discard(Fighter fighter) {
        return false;
    }
}
