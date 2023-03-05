package ru.task1.products.model;

public class Diaper extends ChildrenGoods {
    private String size;
    private int minWeight;
    private int maxWeight;
    private String type;

    public Diaper(String name, double price, double quantity, String unit, int minimumAge, boolean hypoallergenic,
                  String size, int minWeight, int maxWeight, String type) {
        super(name, price, quantity, unit, minimumAge, hypoallergenic);
        this.size = size;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Diaper{" +
                "size='" + size + '\'' +
                ", minWeight=" + minWeight +
                ", maxWeight=" + maxWeight +
                ", type='" + type + '\'' +
                '}';
    }
}
