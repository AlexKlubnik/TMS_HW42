package by.klubnikov.hw4243.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, D> {

    T save(T entity);

    Optional<T> findById(D id);

    List<T> findAll();

    void delete(D id);
}
