package ru.task2.model;

import ru.task2.model.base.WildAnimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Wolf  extends WildAnimal {
    private boolean packLeader;

    public Wolf(int height, int weight, String eyeColor, String habitat, Calendar dateFound, boolean packLeader) {
        super(height, weight, eyeColor, habitat, dateFound);
        this.packLeader = packLeader;
    }

    public boolean isPackLeader() {
        return packLeader;
    }

    @Override
    public void printAbout() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String info = String.format("Animal: %s\n"+
                "Height: %d\n" +
                "Weight: %d\n" +
                "Eye Color: %s\n" +
                "Habitat: %s\n" +
                "Date Found %s\n" +
                "Pack Leader: %b\n"
                ,"Wolf", getHeight(), getWeight(), getEyeColor(),
                getHabitat(), df.format(getDateFound().getTime()), packLeader);
        System.out.println(info);
    }

    @Override
    public void makeSound() {
        System.out.println("\nwolf howl");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Wolf{" +
                "packLeader=" + packLeader +
                '}';
    }
}
