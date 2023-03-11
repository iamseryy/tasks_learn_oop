package ru.task1.products.model;

public abstract class Drink extends Product{
    private double volume;

    public Drink(String name, double price, double quantity, String unit, double volume) {
        super(name, price, quantity, unit);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Drink{" +
                "volume=" + volume +
                '}';
    }
}
