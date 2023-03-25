package ru.task6.service.impl;

import ru.task6.model.Person;
import ru.task6.repository.People;
import ru.task6.repository.impl.PeopleImpl;
import ru.task6.service.PersonService;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {
    private static People people = PeopleImpl.getInstance();

    @Override
    public int addPerson(Person person)  {
        return this.people.add(person);
    }

    @Override
    public Optional<Person> findPersonById(int id) {
        return this.people.findById(id);
    }

    @Override
    public HashSet<Person> findPeopleByName(String name) {
        return findPeople().stream().filter(person -> (person.name().contains(name)
                        || person.surname().contains(name)
                        || person.patronymic().contains(name)))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public HashSet<Person> findPeople() {
        return people.findAll();
    }

    @Override
    public void removePerson(Person person) {
        this.people.delete(person);
    }
}
