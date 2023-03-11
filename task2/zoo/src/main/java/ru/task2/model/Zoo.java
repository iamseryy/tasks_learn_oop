package ru.task2.model;

import ru.task2.model.base.Animal;
import java.util.HashMap;

public class Zoo {
    private HashMap<Integer, Animal> animals;

    public Zoo(HashMap<Integer, Animal> animals) {
        this.animals = animals;
    }

    public HashMap<Integer, Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(HashMap<Integer, Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "animals=" + animals +
                '}';
    }
}
