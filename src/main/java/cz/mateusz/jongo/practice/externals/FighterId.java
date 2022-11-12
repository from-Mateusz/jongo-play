package cz.mateusz.jongo.practice.externals;

import cz.mateusz.jongo.practice.models.Fighter;

import java.util.Objects;

public class FighterId {

    private Long id;

    public static FighterId create(Long id) {
        FighterId fighterId = new FighterId();
        fighterId.setId(id);
        return fighterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FighterId fighterId = (FighterId) o;
        return Objects.equals(id, fighterId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
