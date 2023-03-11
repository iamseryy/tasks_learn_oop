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

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Calendar getDateFound() {
        return dateFound;
    }

    public void setDateFound(Calendar dateFound) {
        this.dateFound = dateFound;
    }

    @Override
    public String toString() {
        return "WildAnimal{" +
                "habitat='" + habitat + '\'' +
                ", dateFound=" + dateFound.getTime() +
                ", height=" + getHeight() +
                ", weight=" + getWeight() +
                ", eyeColor='" + getEyeColor() + '\'' +
                '}';
    }
}
