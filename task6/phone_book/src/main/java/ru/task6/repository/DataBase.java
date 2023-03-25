package ru.task6.repository;

import java.util.HashSet;
import java.util.Optional;

public interface DataBase <T> {
    int add(T entity);
    Optional<T> findById(int id);
    void delete(T entity);
    HashSet<T> findAll();
}
