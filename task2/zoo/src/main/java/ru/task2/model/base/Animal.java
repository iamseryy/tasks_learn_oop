package ru.task2.model.base;

public abstract class Animal {
    private int height;
    private int weight;
    private String eyeColor;

    public Animal(int height, int weight, String eyeColor) {
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public abstract void printAbout();
    public abstract void makeSound();

    @Override
    public String toString() {
        return "Animal{" +
                "height=" + height +
                ", weight=" + weight +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }
}
