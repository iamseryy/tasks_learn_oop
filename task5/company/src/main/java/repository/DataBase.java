package repository;

import model.Person;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public interface DataBase <T> {
    int add(T entity);
    Optional<T> findById(int id);
    void deleteById(int id);
    Optional<HashSet<T>> findAll();

}
