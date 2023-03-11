package ru.task2.view.inputcard;

import ru.task2.model.Cat;
import ru.task2.model.base.Animal;
import ru.task2.view.ViewUtils;

import java.util.Calendar;
import java.util.Optional;

public class CatInputCard implements Inputable {

    @Override
    public Optional<Animal> get(){

        System.out.println("\nThe cat will be added\nComplete the following fields or enter an empty string to cancel");

        String name = ViewUtils.inputStr("Name: ");
        if (name.isEmpty()){
            return Optional.empty();
        }

        String breed = ViewUtils.inputStr("Breed: ");
        if (breed.isEmpty()){
            return Optional.empty();
        }

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

        String coatСolor = ViewUtils.inputStr("Coat Сolor: ");
        if (coatСolor.isEmpty()){
            return Optional.empty();
        }

        Optional<Calendar> birthDateOpt = ViewUtils.inputDate("Birth Date (dd-mm-yyyy): ");
        if (birthDateOpt.isEmpty()){
            return Optional.empty();
        }
        Calendar birthDate = birthDateOpt.get();

        Optional<Boolean> woolPresenceOpt = ViewUtils.inputBool("Wool Presence (true or false): ");
        if (woolPresenceOpt.isEmpty()){
            return Optional.empty();
        }
        boolean woolPresence = woolPresenceOpt.get();

        Optional<Boolean> isVaccinatedOpt = ViewUtils.inputBool("Is Vaccinated (true or false): ");
        if (isVaccinatedOpt.isEmpty()){
            return Optional.empty();
        }
        boolean isVaccinate = isVaccinatedOpt.get();

        Animal cat = new Cat(name, breed, height, weight, eyeColor, coatСolor, birthDate, woolPresence, isVaccinate);

        return Optional.ofNullable(cat);
    }
}
