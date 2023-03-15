package ru.task3.view.inputcard.impl;

import ru.task3.exception.CircleRadiusException;
import ru.task3.model.Circle;
import ru.task3.model.base.Figure;
import ru.task3.view.ViewUtils;
import ru.task3.view.inputcard.EntityCard;

import java.util.Optional;

public class CircleInputCard implements EntityCard {
    @Override
    public Optional<Figure> get(String header) {
        var console = new ViewUtils<Double>();
        System.out.println(header);
        var radius = console.input("Input a radius: ", Double::parseDouble).get();
        try {
            Figure figure = new Circle(radius);
            return Optional.ofNullable(figure);
        }catch (CircleRadiusException e){
            System.out.println("\n" + e.getMessage());
            System.out.println("Figure not added");
            return Optional.empty();
        }
    }
}
