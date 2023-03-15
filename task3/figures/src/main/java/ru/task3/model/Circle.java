package ru.task3.model;

import ru.task3.exception.CircleRadiusException;
import ru.task3.model.base.Figure;
import ru.task3.model.base.Lengthable;

public class Circle implements Figure, Lengthable {
    private double radius;

    public Circle(double radius) throws CircleRadiusException {
        this.radius = radius;
        if (radius <= 0) throw new CircleRadiusException("Radius must be greater than zero");
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getLength() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return  "figure: circle\n" +
                "radius = " + radius + "\n" +
                "circumference = " + getLength() + "\n" +
                "area = " + getArea();
    }
}
