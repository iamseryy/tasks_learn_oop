package ru.task6.view.template.impl;

import ru.task6.model.Person;
import ru.task6.service.PersonService;
import ru.task6.service.impl.PersonServiceImpl;
import ru.task6.view.template.Template;
import ru.task6.view.ui.UserInterface;
import ru.task6.view.ui.impl.UserInterfaceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class DetailedPersonOutputTemplate implements Template {
    private static PersonService personService = new PersonServiceImpl();
    private static UserInterface ui = new UserInterfaceImpl();

    @Override
    public void output() {
        ui.output("\nDetailed person information\n");
        Optional<Integer> idOpt = ui.input("Enter person ID or enter an empty string to cancel: ", Integer::parseInt);

        if(!idOpt.isEmpty()){
            Optional<Person> personOptional = personService.findPersonById(idOpt.get());
            if (!personOptional.isEmpty()){
                Person person = personOptional.get();
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                ui.output("\nName: " + person.surname() + " " + person.name() + " " + person.patronymic());
                ui.output("Date of Birth: " + df.format(person.dateBirth().getTime()));
                ui.output("Home address: " + person.homeAddress());
               // ui.output("Phone numbers: " + person.phoneNumber());

            }else {
                ui.output("\nEmployee not found\n");
            }
        } else{
            ui.output("\nCancelled\n");
        }

        ui.pressEnterToContinue();
    }
}
