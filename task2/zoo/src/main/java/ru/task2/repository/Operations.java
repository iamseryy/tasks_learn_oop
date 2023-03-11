package ru.task2.repository;

import ru.task2.model.base.Animal;

import java.util.HashMap;
import java.util.Optional;

public interface Operations {

    int add(Animal animal);
    Optional<Animal> findById(int id);
    void deleteById(int id);
    Optional<HashMap<Integer, Animal>> findAll();


}
