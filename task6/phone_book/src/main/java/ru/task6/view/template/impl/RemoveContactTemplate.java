package ru.task6.view.template.impl;

import ru.task6.view.template.Template;

import java.util.Optional;

public class RemoveContactTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nRemove contact");
        Optional<Integer> idOpt = ui.input("Enter person ID or enter an empty string to cancel: ", Integer::parseInt);

        int choice = 0;
        if(!idOpt.isEmpty()){
            new DetailedPersonOutputTemplate().outputDetailPersonInfo(idOpt.get());
            while (true){
                Optional<Integer> choiceOptional = ui.input("Remove contact (1 yes/ 2 no)? :", Integer::parseInt);
                if(choiceOptional.isEmpty() || choiceOptional.get() < 1 || choiceOptional.get() > 2){
                    ui.output("Invalid input data! Try Again");
                    continue;
                }
                choice = choiceOptional.get();
                break;
            }

            if(choice == 1){
                personService.removePerson(personService.findPersonById(idOpt.get()).get());
                phoneService.removePhonesByPersonId(idOpt.get());
                notesService.removeNote(notesService.findByPersonId(idOpt.get()).get());

                ui.output("\nСontact deleted\n");
            }else {
                ui.output("\nCancelled\n");
            }

        } else{
            ui.output("\nCancelled\n");
        }

        ui.pressEnterToContinue();
    }
}
