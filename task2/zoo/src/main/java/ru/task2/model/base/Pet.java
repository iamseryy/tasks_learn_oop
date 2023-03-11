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

    public abstract void showAffection();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getCoatСolor() {
        return coatСolor;
    }

    public void setCoatСolor(String coatСolor) {
        this.coatСolor = coatСolor;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", coatСolor='" + coatСolor + '\'' +
                ", birthDate=" + birthDate.getTime() +
                ", height=" + getHeight() +
                ", weight=" + getWeight() +
                ", eyeColor='" + getEyeColor() + '\'' +
                '}';
    }
}
