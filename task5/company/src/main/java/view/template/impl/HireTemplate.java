package view.template.impl;

import model.Person;
import model.Position;
import service.PersonService;
import service.PositionService;
import service.impl.PersonServiceImpl;
import service.impl.PositionServiceImpl;
import view.template.Template;
import view.ui.UserInterface;
import view.ui.impl.UserInterfaceImpl;

import java.text.SimpleDateFormat;
import java.util.*;

public class HireTemplate implements Template {
    private static PersonService personService = new PersonServiceImpl();
    private static PositionService positionService = new PositionServiceImpl();
    private static UserInterface ui = new UserInterfaceImpl();
    @Override
    public void output() {
        ui.output("\nHire an employee");
        ui.output("\nComplete the following fields or enter an empty string to cancel");

        Optional<String> nameOpt = ui.input("Name: ", String::toString);
        if(nameOpt.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        Optional<String> surnameOpt = ui.input("Surname: ", String::toString);
        if(surnameOpt.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        Optional<String> patronymicOpt = ui.input("Patronymic: ", String::toString);
        String patronymic = "";
        if (!patronymicOpt.isEmpty()){
            patronymic = patronymicOpt.get();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Optional<Calendar> birthDateOpt =  ui.input("Birth Date (dd-mm-yyyy): ", sdf::parse);

        if (birthDateOpt.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }
        Date birthDate1 = birthDateOpt.get().;


        Optional<String> homeAddressOpt = ui.input("Home address: ", String::toString);
        if(surnameOpt.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        Optional<String> phoneNumberOpt = ui.input("Phone number: ", String::toString);
        if(surnameOpt.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        ui.output("\nPositions");
        Optional<HashSet<Position>> positions = positionService.findAllPosition();
        if(positions.isEmpty()){
            ui.output("\nThe company has no positions");
            ui.output("\nCancelled\n");
            return;
        }else {
            positions.get().stream()
                    .sorted((position1, position2) -> position1.id() - position2.id())
                    .forEach((position -> {
                        ui.output(position.id() + " " +  position.position());
                    }));
        }

        while (true){
            Optional<Integer> positionOpt = ui.input("Position ID of employee : ", Integer::parseInt);
            if(positionOpt.isEmpty()){
                ui.output("\nCancelled\n");
                return;
            }

            if(positionService.findPositionById(positionOpt.get()).isEmpty()){
                ui.output("Position not found, try again\n");
                continue;
            }

            break;
        }

        int id = 0;
        Optional<HashSet<Person>> personOpt = personService.findAllPersons();
        if(!personOpt.isEmpty()){
            HashSet<Person> people = personOpt.get();
            id = people.stream().max((person1, person2) -> person1.id() - person2.id()).get().id();
        }

//        var newPerson = new Person(id + 1, nameOpt.get(), surnameOpt.get(), patronymic, birthDate,
//                homeAddressOpt.get(), phoneNumberOpt.get());
//
//        personService.addPerson(newPerson);

        ui.output("\nEmployee hired\n");
        ui.pressEnterToContinue();
    }
}
