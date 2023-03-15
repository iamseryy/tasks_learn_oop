package ru.task3.view.inputcard.impl;

import ru.task3.exception.PolygonSideException;
import ru.task3.model.Square;
import ru.task3.model.base.Figure;
import ru.task3.view.ViewUtils;
import ru.task3.view.inputcard.EntityCard;

import java.util.Optional;

public class SquareInputCard implements EntityCard {
    @Override
    public Optional<Figure> get(String header) {
        var console = new ViewUtils<Double>();
        System.out.println(header);
        var values = console.input("Input a side: ", Double::parseDouble).get();

        try {
            Figure figure = new Square(values);
            return Optional.ofNullable(figure);
        }catch (PolygonSideException e){
            System.out.println("\n" + e.getMessage());
            System.out.println("Figure not added");
            return Optional.empty();
        }
    }
}
