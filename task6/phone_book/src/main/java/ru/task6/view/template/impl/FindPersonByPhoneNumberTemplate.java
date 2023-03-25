package ru.task6.view.template.impl;

import ru.task6.model.Person;
import ru.task6.model.Phone;
import ru.task6.view.template.Template;

import java.util.HashSet;
import java.util.Optional;

public class FindPersonByPhoneNumberTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nFind person by phone number\n");
        Optional<String> phoneToFindOption = ui.input("Enter a phone number or part of a phone number " +
                "or enter an empty string to cancel: ", String::toString);
        if(!phoneToFindOption.isEmpty()){
            HashSet<Phone> findedPhones = phoneService.findPhonesByPartOfNumber(phoneToFindOption.get().toLowerCase());
            if(findedPhones.isEmpty()){
                ui.output("\nPhone numbers not found\n");
                ui.pressEnterToContinue();
            } else {
                var persons = new HashSet<Person>();
                findedPhones.stream().forEach(findedPhone -> persons.add(personService.findPersonById(findedPhone.personId()).get()));

                ui.output("");
                persons.stream()
                        .sorted((person1, person2) -> person1.surname().compareTo(person2.surname()))
                        .forEach(person -> ui.output(person.surname() + " " +
                                person.name() + " " + person.patronymic() +
                                " (" + person.id() + ")"));
                new DetailedPersonOutputTemplate().output();
            }
        } else{
            ui.output("\nCancelled\n");
            ui.pressEnterToContinue();
        }

    }
}
