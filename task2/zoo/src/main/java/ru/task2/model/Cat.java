package ru.task2.model;

import ru.task2.model.base.Pet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cat extends Pet{
    private boolean woolPresence;

    public Cat(String name, String breed, int height, int weight, String eyeColor, String coatСolor, Calendar birthDate,
               boolean woolPresence, boolean isVaccinated) {
        super(height, weight, eyeColor, name, breed, isVaccinated, coatСolor, birthDate);
        this.woolPresence = woolPresence;
    }

    public boolean isWoolPresence() {
        return woolPresence;
    }

    @Override
    public void makeSound() {
        System.out.println("\nmeow");
    }

    @Override
    public void showAffection() {
        System.out.println("purr-purr");
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
                ,"Cat", getName(), getBreed(), getHeight(), getWeight(), getEyeColor(),
        getCoatСolor(), df.format(getBirthDate().getTime()), woolPresence, isVaccinated());
        System.out.println(info);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Cat{" +
                "woolPresence=" + woolPresence +
                '}';
    }


}
