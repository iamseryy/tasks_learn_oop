package ru.task1.products.model;

public class ToiletPaper extends HygieneItem{
    private int layersNumber;

    public ToiletPaper(String name, double price, double quantity, String unit, int packageNumberPieces, int layersNumber) {
        super(name, price, quantity, unit, packageNumberPieces);
        this.layersNumber = layersNumber;
    }

    public int getLayersNumber() {
        return layersNumber;
    }

    public void setLayersNumber(int layersNumber) {
        this.layersNumber = layersNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ToiletPaper{" +
                "layersNumber=" + layersNumber +
                '}';
    }
}
