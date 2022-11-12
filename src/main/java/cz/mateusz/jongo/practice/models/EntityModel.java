package cz.mateusz.jongo.practice.models;

import org.jongo.marshall.jackson.oid.MongoId;

import java.util.Objects;

public abstract class EntityModel {

    @MongoId
    private Long id;

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
        EntityModel that = (EntityModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
