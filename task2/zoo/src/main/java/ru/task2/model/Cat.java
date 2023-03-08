package ru.task2.model;

import org.w3c.dom.ls.LSOutput;
import ru.task2.model.base.Pet;
import ru.task2.model.base.Voiceable;

import java.util.Calendar;

public class Cat extends Pet implements Voiceable {
    private boolean woolPresence;

    public Cat(int height, int weight, String eyeColor, String name, String breed, boolean isVaccinated,
               String coatСolor, Calendar birthDate, boolean woolPresence) {
        super(height, weight, eyeColor, name, breed, isVaccinated, coatСolor, birthDate);
        this.woolPresence = woolPresence;
    }

    @Override
    public void makeSound() {
        System.out.println("meow");
    }

    @Override
    protected void showAffection() {
        System.out.println("purr-purr");
    }

    @Override
    protected void printAbout() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() +
                "Cat{" +
                "woolPresence=" + woolPresence +
                '}';
    }
}
