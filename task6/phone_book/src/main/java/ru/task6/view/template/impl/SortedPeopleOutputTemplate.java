package ru.task6.view.template.impl;

import ru.task6.model.Person;
import ru.task6.service.PersonService;
import ru.task6.service.impl.PersonServiceImpl;
import ru.task6.view.template.Template;
import ru.task6.view.ui.UserInterface;
import ru.task6.view.ui.impl.UserInterfaceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Optional;

public class SortedPeopleOutputTemplate implements Template {
    private static PersonService personService = new PersonServiceImpl();
    private static UserInterface ui = new UserInterfaceImpl();


    @Override
    public void output() {
        ui.output("\nAlphabetically sorted list of people\n");
        Optional<HashSet<Person>> people = personService.findPeople();

        if(people.isEmpty()){
            ui.output("\nThere are no entries in the phone book");
        }else {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            people.get().stream()
                    .sorted((person1, person2) -> person1.surname().compareTo(person2.surname()))
                    .forEach((person -> {
                        ui.output(person.surname() + " " + person.name() + " " + person.patronymic() +
                                " " + "(ID: " + person.id() + ")");
                    }));
        }

        ui.pressEnterToContinue();

    }
}
