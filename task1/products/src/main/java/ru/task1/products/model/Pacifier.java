package ru.task1.products.model;

public class Pacifier extends ChildrensGoods{
    public Pacifier(String name, double price, double quantity, String unit, int minimumAge, boolean hypoallergenic) {
        super(name, price, quantity, unit, minimumAge, hypoallergenic);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
