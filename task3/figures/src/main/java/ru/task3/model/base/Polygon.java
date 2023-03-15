package ru.task3.model.base;

import java.util.Arrays;

public abstract class Polygon implements Figure, Perimeterable{
    private double[] sides;

    public Polygon(double[] sides) {
        this.sides = sides;
    }

    public double[] getSides() {
        return sides;
    }

    public void setSides(double[] sides) {
        this.sides = sides;
    }

    @Override
    public double getPerimeter() {
        return Arrays.stream(sides).sum();
    }


}
