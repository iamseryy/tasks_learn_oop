package ru.task2.model;

import ru.task2.model.base.WildAnimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tiger extends WildAnimal {

    public Tiger(int height, int weight, String eyeColor, String habitat, Calendar dateFound) {
        super(height, weight, eyeColor, habitat, dateFound);
    }

    @Override
    public void printAbout() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String info = String.format("Animal: %s\n"+
                "Height: %d\n" +
                "Weight: %d\n" +
                "Eye Color: %s\n" +
                "Habitat: %s\n" +
                "Date Found: %s\n"
                ,"Tiger", getHeight(), getWeight(), getEyeColor(), getHabitat(), df.format(getDateFound().getTime()));
        System.out.println(info);
    }

    @Override
    public void makeSound() {
        System.out.println("\ntiger roar");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
