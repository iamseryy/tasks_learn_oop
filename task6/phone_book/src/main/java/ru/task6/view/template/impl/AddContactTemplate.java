package ru.task6.view.template.impl;

import ru.task6.model.Note;
import ru.task6.model.Person;
import ru.task6.model.Phone;
import ru.task6.model.PhoneNumberType;
import ru.task6.view.template.Template;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

public class AddContactTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nAdd contact\n");
        ui.output("Complete the following fields or enter an empty string to cancel\n");

        int personId = personService.findPeople().stream()
                .max((person1, person2) -> person1.id() - person2.id()).get().id() + 1;

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
        Optional<Date> birthDateOpt =  ui.input("Birth Date (dd-mm-yyyy): ", sdf::parse);

        if (birthDateOpt.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(birthDateOpt.get());

        Optional<String> homeAddressOpt = ui.input("Home address: ", String::toString);
        if(surnameOpt.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        var newPhones = new HashSet<Phone>();

        while (true){
            Optional<String> phoneNumberOpt = ui.input("Phone number: ", String::toString);
            if(surnameOpt.isEmpty()){
                ui.output("\nCancelled\n");
                return;
            }
            while (true){
                Optional<Integer> typeOptional = ui.input("Phone number type (1 HOME/ 2 WORK/ 3 MOBILE): ", Integer::parseInt);
                if(typeOptional.isEmpty()){
                    ui.output("\nCancelled\n");
                    return;
                }

                if (typeOptional.get() < 1 || typeOptional.get() > 3){
                    ui.output("Invalid input data! Try Again");
                    continue;
                }

                PhoneNumberType phoneNumberType = switch (typeOptional.get()){
                   case 1 -> PhoneNumberType.HOME;
                   case 2 -> PhoneNumberType.WORK;
                   case 3 -> PhoneNumberType.MOBILE;
                   default -> throw new IllegalArgumentException("unknown phone number type");
                };

                newPhones.add(new Phone(personId, phoneNumberOpt.get(), phoneNumberType));

                break;
            }

            Optional<Integer> choice;
            while (true) {
                choice = ui.input("Add another phone number (1 yes/ 2 no)?: ", Integer::parseInt);
                if(choice.isEmpty() || choice.get() < 1 || choice.get() > 2){
                    ui.output("Invalid input data! Try Again");
                    continue;
                }
                break;
            }

            if(choice.get() == 1){
                continue;
            }

            break;
        }

        String note = "";
        Optional<String> noteOpt = ui.input("Note: ", String::toString);
        if(!noteOpt.isEmpty()){
            note = noteOpt.get();
        }

        var newPerson = new Person(personId, nameOpt.get(), surnameOpt.get(), patronymic, birthDate,
                homeAddressOpt.get());
        personService.addPerson(newPerson);
        newPhones.forEach(phone -> phoneService.addPhone(phone));
        notesService.addNote(new Note(personId, note));

        ui.output("\nContact added\n");
        ui.pressEnterToContinue();
    }
}
