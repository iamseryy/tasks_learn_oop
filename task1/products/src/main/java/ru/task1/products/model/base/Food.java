package ru.task1.products.model;

import java.util.Calendar;

public abstract class Food extends Product{
    private Calendar expirationDate;

    public Food(String name, double price, double quantity, String unit, Calendar expirationDate) {
        super(name, price, quantity, unit);
        this.expirationDate = expirationDate;
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
                "Food{" +
                "expirationDate=" + expirationDate.getTime() +
                '}';
    }
}
