package view.template.impl;

import model.HirePerson;
import model.Person;
import model.Status;
import service.HirePersonService;
import service.PersonService;
import service.PositionService;
import service.impl.HirePersonServiceImpl;
import service.impl.PersonServiceImpl;
import service.impl.PositionServiceImpl;
import view.template.Template;
import view.ui.UserInterface;
import view.ui.impl.UserInterfaceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public class FireTemplate implements Template {
    private static PersonService personService = new PersonServiceImpl();
    private static PositionService positionService = new PositionServiceImpl();
    private static HirePersonService hirePersons = new HirePersonServiceImpl();
    private static UserInterface ui = new UserInterfaceImpl();

    @Override
    public void output() {
        ui.output("\nFire an employee");
        Optional<Integer> idOpt = ui.input("Enter employee ID or enter an empty string to cancel: ", Integer::parseInt);
        if(!idOpt.isEmpty()){
            Optional<Person> personOptional = personService.findPersonById(idOpt.get());
            if (!personOptional.isEmpty()){
                Person person = personOptional.get();
                ui.output("Name: " + person.name());
                ui.output("Surname: " + person.surname());
                ui.output("Patronymic: " + person.patronymic());
                String status = hirePersons.findLastHireOperationByPersonId(person.id()).get().hireType().getDescription();
                Optional<HirePerson> hirePersonOptional = hirePersons.findLastHireOperationByPersonId(person.id());
                String position = positionService.findPositionById(hirePersonOptional.get().positionId()).get().position();
                ui.output("Position: " + position);
                ui.output("Status: " + status);
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                Calendar calendar = hirePersons.findLastHireOperationByPersonId(person.id()).get().hireDate();
                if(status.equals(Status.HIRED.getDescription())){
                    ui.output("Hired date: " + df.format(calendar.getTime()));
                    while (true){
                        Optional<Integer> choice = ui.input("Fire an employee? (1 yes/ 2 No): ", Integer::parseInt);
                        if(choice.isEmpty() || choice.get() != 1 || choice.get() != 2){
                           ui.output("Invalid input data! Try Again");
                        }
                        if(choice.get() == 1){
//                            hirePersonOptional.get().hireType() = Status.FIRED;

                        }else {
                            ui.output("\nCancelled\n");
                        }

                        break;
                    }

                }else {
                   ui.output("Fired date: " + df.format(calendar.getTime()));
                   ui.output("\nEmployee already fired");
                }

            }else {
                ui.output("\nEmployee not found\n");
            }
        } else {
            ui.output("\nCancelled\n");
        }

        ui.pressEnterToContinue();
    }
}
