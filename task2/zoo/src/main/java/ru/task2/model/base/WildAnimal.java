package ru.task2.model.base;

import java.util.Calendar;

public abstract class WildAnimal extends Animal{
    String habitat;
    Calendar dateFound;

    public WildAnimal(int height, int weight, String eyeColor, String habitat, Calendar dateFound) {
        super(height, weight, eyeColor);
        this.habitat = habitat;
        this.dateFound = dateFound;
    }

    @Override
    public String toString() {
        return "WildAnimal{" +
                "habitat='" + habitat + '\'' +
                ", dateFound=" + dateFound +
                ", height=" + height +
                ", weight=" + weight +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }
}
