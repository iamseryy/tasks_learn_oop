package ru.task2.model;

import ru.task2.model.base.Bird;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stork extends Bird {

    public Stork(int height, int weight, String eyeColor, int flightAltitude) {
        super(height, weight, eyeColor, flightAltitude);
    }

    @Override
    public void printAbout() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String info = String.format("Animal: %s\n"+
                        "Height: %d\n" +
                        "Weight: %d\n" +
                        "Eye Color: %s\n" +
                        "Flight Altitude: %d\n"
                ,"Stork", getHeight(), getWeight(), getEyeColor(), getFlightAltitude());
        System.out.println(info);
    }

    @Override
    public void makeSound() {
        System.out.println("\nstork sounds");
    }
}
