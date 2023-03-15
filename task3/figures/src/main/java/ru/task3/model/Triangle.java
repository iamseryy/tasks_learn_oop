package ru.task3.model;

import ru.task3.exception.PolygonSideException;
import ru.task3.exception.TriangleExistsException;
import ru.task3.model.base.Polygon;

public class Triangle extends Polygon {
    public Triangle(double a, double b, double c) throws PolygonSideException, TriangleExistsException {
        super(new double[]{a, b, c});
        if (a <= 0 || b <= 0 || c <= 0) throw new PolygonSideException("Side must be greater than zero");
        if (a >= b + c || b >= a + c || c >= a + b) throw new TriangleExistsException("Such a triangle does not exist");
    }
    @Override
    public double getArea() {
        double p = getPerimeter() / 2.0;
        return Math.sqrt(p * (p - getSides()[0]) * (p - getSides()[1]) * (p - getSides()[2]));
    }

    @Override
    public String toString() {
        return "figure: triangle\n" +
                "side A = " + getSides()[0] + "\n" +
                "side B = " + getSides()[1] + "\n" +
                "side C = " + getSides()[2] + "\n" +
                "perimeter = " + super.getPerimeter() + "\n" +
                "area = " + getArea();
    }
}
