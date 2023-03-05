package ru.task1.products.model;

import java.util.Calendar;


public class Bread extends Food{
    private String flourType;

    public Bread(String name, double price, double quantity, String unit, Calendar expirationDate, String flourType) {
        super(name, price, quantity, unit, expirationDate);
        this.flourType = flourType;
    }

    public String getFlourType() {
        return flourType;
    }

    public void setFlourType(String flourType) {
        this.flourType = flourType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Bread{" +
                "flourType='" + flourType + '\'' +
                '}';
    }
}
