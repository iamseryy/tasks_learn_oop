package ru.task3.view.inputcard.impl;

import ru.task3.exception.PolygonSideException;
import ru.task3.model.Rectangle;
import ru.task3.model.base.Figure;
import ru.task3.view.ViewUtils;
import ru.task3.view.inputcard.EntityCard;

import java.util.Optional;

public class RectangleInputCard implements EntityCard {
    @Override
    public Optional<Figure> get(String header) {
        var console = new ViewUtils<Double>();
        System.out.println(header);
        String[] sides = new String[]{"A", "B"};
        Double[] values = new Double[2];

        for (int i = 0; i < sides.length; i++){
            values[i] = console.input("Input a side " + sides[i] + ": ", Double::parseDouble).get();
        }

        try {
            Figure figure = new Rectangle(values[0], values[1]);
            return Optional.ofNullable(figure);
        }catch (PolygonSideException e){
            System.out.println("\n" + e.getMessage());
            System.out.println("Figure not added");
            return Optional.empty();
        }
    }
}
