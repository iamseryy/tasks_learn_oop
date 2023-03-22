package view.template.impl;

import model.Person;
import service.PersonService;
import service.impl.PersonServiceImpl;
import view.template.Template;
import view.ui.UserInterface;
import view.ui.impl.UserInterfaceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Optional;

public class PrintPersonsTemplate implements Template {
    private static PersonService personService = new PersonServiceImpl();
    private static UserInterface ui = new UserInterfaceImpl();

    @Override
    public void output() {
        ui.output("\nCompany employees\n");
        Optional<HashSet<Person>> people = personService.findAllPersons();
        if(people.isEmpty()){
            ui.output("\nThe company has no employees");
        }else {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            people.get().stream()
                    .sorted((person1, person2) -> person1.id() - person2.id())
                    .forEach((person -> {
                        ui.output("\nID: " + person.id());
                        ui.output("Name: " + person.name());
                        ui.output("Surname: " + person.surname());
                        ui.output("Patronymic: " + person.patronymic());
                        ui.output("Date of Birth: " + df.format(person.dateBirth().getTime()));
                        ui.output("Home address: " + person.homeAddress());
                        ui.output("Phone number: " + person.phoneNumber());
                    }));
        }

        ui.pressEnterToContinue();
    }
}
