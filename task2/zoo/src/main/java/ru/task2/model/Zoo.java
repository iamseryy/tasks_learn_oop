package ru.task2.model;

import ru.task2.model.base.Animal;

import java.util.HashMap;
import java.util.HashSet;

public class Zoo {
    private HashMap<Integer, Animal> animals;

    public Zoo(HashMap<Integer, Animal> animals) {
        this.animals = animals;
    }

    public HashMap<Integer, Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        int id;
        if (this.animals.isEmpty()){
            id = 0;
        }else {
            id = this.animals.entrySet().stream()
                    .max((animal1, animal2) -> animal1.getKey() - animal2.getKey())
                    .get()
                    .getKey();
        }

        this.animals.put(id + 1, animal);
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "animals=" + animals +
                '}';
    }
}
