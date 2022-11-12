package cz.mateusz.jongo.practice.models;

import java.time.LocalDateTime;

public class Fight extends EntityModel {

    private Fighter opponent;

    private LocalDateTime when;

    private Location where;
    private FightResult result;

    public Fight(Fighter opponent) {
        this.opponent = opponent;
    }

    public Fighter getOpponent() {
        return opponent;
    }

    public FightResult getResult() {
        return result;
    }

    public void setResult(FightResult result) {
        this.result = result;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public Location getWhere() {
        return where;
    }
}
