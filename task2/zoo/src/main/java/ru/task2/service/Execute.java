package ru.task2.service;

import ru.task2.model.base.Animal;

@FunctionalInterface
public interface Execute {
    void AnimalExecute(Animal animal);
}
