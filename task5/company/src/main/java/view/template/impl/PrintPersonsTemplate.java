package view.template.impl;

import model.Person;
import model.Status;
import service.HirePersonService;
import service.PersonService;
import service.PositionService;
import service.SalaryService;
import service.impl.HirePersonServiceImpl;
import service.impl.PersonServiceImpl;
import service.impl.PositionServiceImpl;
import service.impl.SalaryServiceImpl;
import view.template.Template;
import view.ui.UserInterface;
import view.ui.impl.UserInterfaceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;

public class PrintPersonsTemplate implements Template {
    private static PersonService personService = new PersonServiceImpl();
    private static PositionService positionService = new PositionServiceImpl();
    private static HirePersonService hirePersons = new HirePersonServiceImpl();
    private static SalaryService salaryService = new SalaryServiceImpl();
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
                        String status = hirePersons.findLastHireOperationByPersonId(person.id()).get().getHireType().getDescription();
                        String position = positionService.findPositionById(hirePersons.findLastHireOperationByPersonId(person.id())
                                .get().getPositionId()).get().position();
                        ui.output("Position: " + position);
                        ui.output("Status: " + status);
                        Calendar calendar = hirePersons.findLastHireOperationByPersonId(person.id()).get().getHireDate();
                        if(status.equals(Status.FIRED.getDescription())){
                            ui.output("Fired date: " + df.format(calendar.getTime()));
                        }else {
                            ui.output("Hired date: " + df.format(calendar.getTime()));
                            ui.output("Salary: " + salaryService.findSalaryByEmployeeId(person.id()).get().getSalaryValue());
                        }
                    }));
        }

        ui.pressEnterToContinue();
    }
}
