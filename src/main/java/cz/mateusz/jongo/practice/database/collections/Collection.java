package cz.mateusz.jongo.practice.database.collections;

import java.util.List;
import java.util.Optional;

public interface Collection<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T t);
    T remove(T t);
}
