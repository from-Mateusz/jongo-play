package cz.mateusz.jongo.practice.services;

import cz.mateusz.jongo.practice.externals.FighterId;
import cz.mateusz.jongo.practice.models.Fighter;

import java.util.Optional;

public interface FightersService {
    FighterId register(Fighter fighter);
    Optional<Fighter> findFighterWithBestRecord();
    Optional<Fighter> findFighterWithWorstRecord();
    boolean discard(Fighter fighter);
}
