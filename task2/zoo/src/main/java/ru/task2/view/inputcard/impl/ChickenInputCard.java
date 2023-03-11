package ru.task2.view.inputcard.impl;

import ru.task2.model.Chicken;
import ru.task2.model.base.Animal;
import ru.task2.view.ViewUtils;
import ru.task2.view.inputcard.EntityCard;

import java.util.Optional;

public class ChickenInputCard implements EntityCard {

    @Override
    public Optional<Animal> get() {
        System.out.println("\nThe chicken will be added\nComplete the following fields or enter an empty string to cancel");

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
        Optional<Integer> flightAltitudeOpt = ViewUtils.inputInt("Flight Altitude: ");
        if (flightAltitudeOpt.isEmpty()){
            return Optional.empty();
        }
        int flightAltitude = flightAltitudeOpt.get();

        Animal chicken = new Chicken(height, weight, eyeColor, flightAltitude);

        return Optional.ofNullable(chicken);
    }
}
