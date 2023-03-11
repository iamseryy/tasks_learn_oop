package ru.task2.repository;

import ru.task2.model.Cat;
import ru.task2.model.Zoo;
import ru.task2.model.base.Animal;

import java.util.HashMap;
import java.util.Optional;

public class DataBase implements Operations{
    public static Zoo zoo = new Zoo(new HashMap<>());

    private static DataBase instance;

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    @Override
    public int add(Animal animal) {
        int id;
        if (this.zoo.getAnimals().isEmpty()){
            id = 0;
        }else {
            id = this.zoo.getAnimals().entrySet().stream()
                    .max((animal1, animal2) -> animal1.getKey() - animal2.getKey())
                    .get()
                    .getKey();
        }

        HashMap<Integer, Animal> newZooAnimal = zoo.getAnimals();
        newZooAnimal.put(id + 1 , animal);
        this.zoo.setAnimals(newZooAnimal);

        return id + 1;
    }

    @Override
    public Optional<Animal> findById(int id) {
        if (this.zoo.getAnimals().isEmpty()){
            return Optional.empty();
        }else {
            var animal = this.zoo.getAnimals().get(id);

            return Optional.ofNullable(animal);
        }
    }

    @Override
    public void deleteById(int id) {
        if (!this.zoo.getAnimals().isEmpty()){
            this.zoo.getAnimals().remove(id);
        }
    }

    @Override
    public Optional<HashMap<Integer, Animal>> findAll() {
        if (this.zoo.getAnimals().isEmpty()){
            return Optional.empty();
        }

        return Optional.ofNullable(this.zoo.getAnimals());
    }
}
