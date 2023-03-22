package service;

import model.Person;

import java.util.HashSet;
import java.util.Optional;

public interface PersonService {
    int addPerson(Person person);
    boolean removePersonById(int id);
    boolean updatePerson(int id);
    Optional<Person> findPersonById(int id);
    Optional<HashSet<Person>> findAllPersons();


}
