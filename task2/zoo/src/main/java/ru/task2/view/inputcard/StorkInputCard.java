package ru.task2.view.inputcard;

import ru.task2.model.Stork;
import ru.task2.model.base.Animal;
import ru.task2.view.ViewUtils;

import java.util.Optional;

public class StorkInputCard implements Inputable {

    @Override
    public Optional<Animal> get() {
        System.out.println("\nThe stork will be added\nComplete the following fields or enter an empty string to cancel");

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

        Animal stork = new Stork(height, weight, eyeColor, flightAltitude);

        return Optional.ofNullable(stork);
    }
}
