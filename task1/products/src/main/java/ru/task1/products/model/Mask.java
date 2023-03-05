package ru.task1.products.model;

public class Mask extends HygieneItem{
    public Mask(String name, double price, double quantity, String unit, int packageNumberPieces) {
        super(name, price, quantity, unit, packageNumberPieces);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
