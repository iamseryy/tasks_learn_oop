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

public class PrintPersonTemplate implements Template {
    private static PersonService personService = new PersonServiceImpl();
    private static UserInterface ui = new UserInterfaceImpl();

    @Override
    public void output() {
        ui.output("\nCompany employee\n");
        Optional<Integer> idOpt = ui.input("Enter ID or enter an empty string to cancel: ", Integer::parseInt);

        if(!idOpt.isEmpty()){
            Optional<Person> personOptional = personService.findPersonById(idOpt.get());
            if (!personOptional.isEmpty()){
                Person person = personOptional.get();
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

                ui.output("\nID: " + person.id());
                ui.output("Name: " + person.name());
                ui.output("Surname: " + person.surname());
                ui.output("Patronymic: " + person.patronymic());
                ui.output("Date of Birth: " + df.format(person.dateBirth().getTime()));
                ui.output("Home address: " + person.homeAddress());
                ui.output("Phone number: " + person.phoneNumber());
            }else {
                ui.output("\nEmployee not found\n");
            }
        } else{
            ui.output("\nCancelled\n");}

        ui.pressEnterToContinue();
    }
}
