package ru.task2.view.inputcard;

import ru.task2.model.Wolf;
import ru.task2.model.base.Animal;
import ru.task2.view.ViewUtils;

import java.util.Calendar;
import java.util.Optional;

public class WolfInputCard implements Inputable {
    @Override
    public Optional<Animal> get() {
        System.out.println("\nThe wolf will be added\nComplete the following fields or enter an empty string to cancel");

        Optional<Integer> heightOpt = ViewUtils.inputInt("Height: ");
        if (heightOpt.isEmpty()){
            return Optional.empty();
        }
        int height = heightOpt.get();

        Optional<Integer> weightOpt = ViewUtils.inputInt("Weight: ");
        if (weightOpt.isEmpty()){
            return Optional.empty();
        }
        int weight = heightOpt.get();

        String eyeColor = ViewUtils.inputStr("Eye Color: ");
        if (eyeColor.isEmpty()){
            return Optional.empty();
        }

        String habitat = ViewUtils.inputStr("Habitat: ");
        if (habitat.isEmpty()){
            return Optional.empty();
        }

        Optional<Calendar> dateFoundOpt = ViewUtils.inputDate("Date Found (dd-mm-yyyy): ");
        if (dateFoundOpt.isEmpty()){
            return Optional.empty();
        }
        Calendar dateFound = dateFoundOpt.get();

        Optional<Boolean> packLeaderOpt = ViewUtils.inputBool("Pack Leader (true or false): ");
        if (packLeaderOpt.isEmpty()){
            return Optional.empty();
        }
        boolean packLeader = packLeaderOpt.get();

        Animal wolf = new Wolf(height, weight, eyeColor, habitat, dateFound, packLeader);

        return Optional.ofNullable(wolf);
    }
}
