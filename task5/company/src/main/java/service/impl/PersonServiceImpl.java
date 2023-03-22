package service.impl;

import model.Person;
import repository.Persons;
import repository.impl.PersonsImpl;
import service.PersonService;

import java.util.HashSet;
import java.util.Optional;

public class PersonServiceImpl implements PersonService {
    private static Persons persons = PersonsImpl.getInstance();

    @Override
    public int addPerson(Person person) {
        return 0;
    }

    @Override
    public boolean removePersonById(int id) {
        return false;
    }

    @Override
    public boolean updatePerson(int id) {
        return false;
    }

    @Override
    public Optional<Person> findPersonById(int id) {
        return persons.findById(id);
    }

    @Override
    public Optional<HashSet<Person>> findAllPersons() {
        return persons.findAll();
    }
}
