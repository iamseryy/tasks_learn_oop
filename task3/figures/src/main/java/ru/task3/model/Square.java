package ru.task3.model;

import ru.task3.exception.PolygonSideException;

public class Square extends Rectangle{
    public Square(double a) throws PolygonSideException {
        super(a, a);
    }

    @Override
    public String toString() {
        return "figure: square\n" +
                "side = " + getSides()[0] + "\n" +
                "perimeter = " + super.getPerimeter() + "\n" +
                "area = " + getArea();
    }
}

