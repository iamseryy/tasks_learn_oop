package ru.task3.model;

import ru.task3.exception.PolygonSideException;
import ru.task3.model.base.Polygon;

public class Rectangle extends Polygon {

    public Rectangle(double a, double b) throws PolygonSideException{
        super(new double[]{a, b, a, b});
        if (a <= 0 || b <= 0) throw new PolygonSideException("Side must be greater than zero");
    }

    @Override
    public double getArea() {
        return getSides()[0] * getSides()[1];
    }

    @Override
    public String toString() {
        return "figure: rectangle\n" +
                "side A = " + getSides()[0] + "\n" +
                "side B = " + getSides()[1] + "\n" +
                "perimeter = " + super.getPerimeter() + "\n" +
                "area = " + getArea();
    }
}
