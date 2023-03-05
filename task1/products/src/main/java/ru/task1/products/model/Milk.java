package ru.task1.products.model;

import java.util.Calendar;


public class Milk extends Drink{
    private double fatPercentage;
    private Calendar expirationDate;

    public Milk(String name, double price, double quantity, String unit, double volume, double fatPercentage, Calendar expirationDate) {
        super(name, price, quantity, unit, volume);
        this.fatPercentage = fatPercentage;
        this.expirationDate = expirationDate;
    }

    public double getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Milk{" +
                "fatPercentage=" + fatPercentage +
                ", expirationDate=" + expirationDate.getTime() +
                '}';
    }
}
