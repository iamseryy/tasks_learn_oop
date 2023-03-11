package ru.task2.model;

import ru.task2.model.base.Pet;
import ru.task2.model.base.Trainedable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dog extends Pet implements Trainedable {
    private boolean trained;

    public Dog(String name, String breed, int height, int weight, String eyeColor, String coatСolor, Calendar birthDate,
               boolean trained, boolean isVaccinated) {
        super(height, weight, eyeColor, name, breed, isVaccinated, coatСolor, birthDate);
        this.trained = trained;
    }

    public boolean isTrained()  {
        return trained;
    }

    @Override
    public void Sit() {
        System.out.println("The dog " + getName() + " sat down");
    }

    @Override
    public void Lie() {
        System.out.println("The dog " + getName() + " lay down");
    }

    @Override
    public void SpinAround() {
        System.out.println("The dog " + getName() + " was spinning");
    }

    @Override
    public void printAbout() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String info = String.format("Animal: %s\n"+
                        "Name: %s\n" +
                        "Breed: %s\n" +
                        "Height: %d\n" +
                        "Weight: %d\n" +
                        "Eye Color: %s\n" +
                        "Coat Сolor: %s\n" +
                        "Birth Date: %s\n" +
                        "Wool Presence: %b\n" +
                        "Is Vaccinated: %b\n"
                , "Dog", getName(), getBreed(), getHeight(), getWeight(), getEyeColor(),
                getCoatСolor(), df.format(getBirthDate().getTime()), trained, isVaccinated());
        System.out.println(info);
    }

    @Override
    public void showAffection() {
        System.out.println("wag the tail");
    }

    @Override
    public void makeSound() {
        System.out.println("\nwoof");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Dog{" +
                "trained=" + trained +
                '}';
    }
}
