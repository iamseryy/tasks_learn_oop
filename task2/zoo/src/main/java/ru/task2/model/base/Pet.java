package ru.task2.model.base;

import java.util.Calendar;

public abstract class Pet extends Animal{
    String name;
    String breed;
    boolean isVaccinated;
    String coatСolor;
    Calendar birthDate;

    public Pet(int height, int weight, String eyeColor, String name, String breed, boolean isVaccinated,
               String coatСolor, Calendar birthDate) {
        super(height, weight, eyeColor);
        this.name = name;
        this.breed = breed;
        this.isVaccinated = isVaccinated;
        this.coatСolor = coatСolor;
        this.birthDate = birthDate;
    }

    protected abstract void showAffection();


    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", coatСolor='" + coatСolor + '\'' +
                ", birthDate=" + birthDate.getTime() +
                ", height=" + height +
                ", weight=" + weight +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }
}
