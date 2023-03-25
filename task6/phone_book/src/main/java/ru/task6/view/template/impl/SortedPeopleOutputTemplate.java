package ru.task6.view.template.impl;

import ru.task6.model.Person;
import ru.task6.view.template.Template;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;

public class SortedPeopleOutputTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nAlphabetically sorted list of people\n");
        HashSet<Person> people = personService.findPeople();

        if(people.isEmpty()){
            ui.output("\nThere are no entries in the phone book");
        }else {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            people.stream()
                    .sorted((person1, person2) -> person1.surname().compareTo(person2.surname()))
                    .forEach((person -> {
                        ui.output(person.surname() + " " + person.name() + " " + person.patronymic() +
                                " " + "(ID: " + person.id() + ")");
                    }));
        }

        ui.pressEnterToContinue();
    }
}
