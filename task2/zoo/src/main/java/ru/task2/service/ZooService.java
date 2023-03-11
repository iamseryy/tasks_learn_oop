package ru.task2.service;

import ru.task2.model.base.Animal;
import java.util.Optional;


public interface ZooService {
    void addAnimal(Optional<Animal> animal);
    void printAnimals();
    void printDetailAnimal();
    void removeAnimal();
    void makeAnimalSound();
    void makeAllAnimalSound();
    void letGoFly();
    void petAnAnimal();
    void training();
}
