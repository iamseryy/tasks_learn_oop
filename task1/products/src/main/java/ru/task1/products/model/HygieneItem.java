package ru.task1.products.model;

public abstract class HygieneItem extends Product{

    private int packageNumberPieces;

    public HygieneItem(String name, double price, double quantity, String unit, int packageNumberPieces) {
        super(name, price, quantity, unit);
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
                "HygieneItem{" +
                "packageNumberPieces=" + packageNumberPieces +
                '}';
    }
}
