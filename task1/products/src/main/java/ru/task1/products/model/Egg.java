package ru.task1.products.model;

import java.util.Calendar;

public class Egg extends Food{
    private int packageNumberPieces;

    public Egg(String name, double price, double quantity, String unit, Calendar expirationDate, int packageNumberPieces) {
        super(name, price, quantity, unit, expirationDate);
        this.packageNumberPieces = packageNumberPieces;
    }

    public int getPackageNumberPieces() {
        return packageNumberPieces;
    }

    public void setPackageNumberPieces(int packageNumberPieces) {
        this.packageNumberPieces = packageNumberPieces;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Egg{" +
                "packageNumberPieces=" + packageNumberPieces +
                '}';
    }
}
