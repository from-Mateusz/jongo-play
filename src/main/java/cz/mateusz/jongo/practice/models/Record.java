package cz.mateusz.jongo.practice.models;

public class Record {

    private int wins;

    private int losses;

    public Record(int wins, int losses) {
        this.wins = wins;
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
}
