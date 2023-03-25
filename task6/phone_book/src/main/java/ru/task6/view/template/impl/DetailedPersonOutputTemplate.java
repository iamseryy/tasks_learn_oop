package ru.task6.view.template.impl;

import ru.task6.model.Note;
import ru.task6.model.Person;
import ru.task6.model.Phone;
import ru.task6.view.template.Template;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Optional;

public class DetailedPersonOutputTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nDetailed person information\n");
        Optional<Integer> idOpt = ui.input("Enter person ID or enter an empty string to cancel: ", Integer::parseInt);

        if(!idOpt.isEmpty()){
            outputDetailPersonInfo(idOpt.get());
        } else{
            ui.output("\nCancelled\n");
        }

        ui.pressEnterToContinue();
    }

    public void outputDetailPersonInfo(int personId) {

        Optional<Person> personOptional = personService.findPersonById(personId);
        if (!personOptional.isEmpty()) {
            Person person = personOptional.get();
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            ui.output("\nName: " + person.surname() + " " + person.name() + " " + person.patronymic());
            ui.output("Date of Birth: " + df.format(person.dateBirth().getTime()));
            ui.output("Home address: " + person.homeAddress());

            HashSet<Phone> personPhones = phoneService.findAllPhonesByPersonId(personId);
            if (personPhones.isEmpty()) {
                ui.output("Phone numbers: there is none");
            } else {
                personPhones.stream()
                        .forEach(phone -> ui.output(phone.type().getDescription() + " phone number: " + phone.phone()));
            }

            Optional<Note> noteOptional = notesService.findByPersonId(personId);
            if (noteOptional.isEmpty()) {
                ui.output("Note: there is none");
            } else {
                ui.output("Note: " + noteOptional.get().note());
            }
        } else {
            ui.output("\nEmployee not found\n");
        }
    }
}
