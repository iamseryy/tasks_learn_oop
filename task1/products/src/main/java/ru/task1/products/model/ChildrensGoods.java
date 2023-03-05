package ru.task1.products.model;

public abstract class ChildrensGoods extends Product{
    private int minimumAge;
    private boolean hypoallergenic;

    public ChildrensGoods(String name, double price, double quantity, String unit, int minimumAge, boolean hypoallergenic) {
        super(name, price, quantity, unit);
        this.minimumAge = minimumAge;
        this.hypoallergenic = hypoallergenic;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public boolean isHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(boolean hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ChildrensGoods{" +
                "minimumAge=" + minimumAge +
                ", hypoallergenic=" + hypoallergenic +
                '}';
    }
}
