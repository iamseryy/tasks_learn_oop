package ru.task6.view.template.impl;

import ru.task6.model.Person;
import ru.task6.view.template.Template;

import java.util.HashSet;
import java.util.Optional;

public class FindPersonByNameTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nFind person by name\n");
        Optional<String> nameToFindOption = ui.input("Enter a name or part of a name or enter an empty string to cancel: ", String::toString);
        if(!nameToFindOption.isEmpty()){
           HashSet<Person> persons = personService.findPeopleByName(nameToFindOption.get().toLowerCase());
           if(persons.isEmpty()){
               ui.output("\nNo people found\n");
               ui.pressEnterToContinue();
           }else {
               ui.output("");
               persons.stream()
                       .sorted((person1, person2) -> person1.surname().compareTo(person2.surname()))
                       .forEach(person -> ui.output(person.surname() + " " +
                               person.name() + " " + person.patronymic() +
                               " (ID " + person.id() + ")"));

               new DetailedPersonOutputTemplate().output();
           }
        } else{
            ui.output("\nCancelled\n");
            ui.pressEnterToContinue();
        }

    }
}
