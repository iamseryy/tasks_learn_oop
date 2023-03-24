package ru.task6.service;

import ru.task6.model.Person;

import java.util.HashSet;
import java.util.Optional;

public interface PersonService {
    int addPerson(Person person);
    Optional<Person> findPersonById(int id);
    Optional<HashSet<Person>> findPeople();
}
