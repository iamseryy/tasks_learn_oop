package ru.task2.view.inputcard.impl;

import ru.task2.model.Tiger;
import ru.task2.model.base.Animal;
import ru.task2.view.ViewUtils;
import ru.task2.view.inputcard.EntityCard;

import java.util.Calendar;
import java.util.Optional;

public class TigerInputCard implements EntityCard {
    @Override
    public Optional<Animal> get() {
        System.out.println("\nThe tiger will be added\nComplete the following fields or enter an empty string to cancel");

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

        Animal tiger = new Tiger(height, weight, eyeColor, habitat, dateFound);

        return Optional.ofNullable(tiger);
    }
}
