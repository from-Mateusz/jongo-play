package cz.mateusz.jongo.practice.models;

public class Ticket {

    private Fight fight;

    private Fan owner;

    public Fight getFight() {
        return fight;
    }

    public void setFight(Fight fight) {
        this.fight = fight;
    }

    public Fan getOwner() {
        return owner;
    }

    public void setOwner(Fan owner) {
        this.owner = owner;
    }
}
