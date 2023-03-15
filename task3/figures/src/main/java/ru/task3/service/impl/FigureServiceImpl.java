package ru.task3.service.impl;


import ru.task3.model.Circle;
import ru.task3.model.Rectangle;
import ru.task3.model.Square;
import ru.task3.model.Triangle;
import ru.task3.model.base.Figure;
import ru.task3.model.base.Polygon;
import ru.task3.repository.FigureCollections;
import ru.task3.repository.impl.FigureCollectionsImpl;
import ru.task3.service.FigureService;
import ru.task3.view.ViewUtils;
import ru.task3.view.inputcard.impl.CircleInputCard;
import ru.task3.view.inputcard.impl.RectangleInputCard;
import ru.task3.view.inputcard.impl.SquareInputCard;
import ru.task3.view.inputcard.impl.TriangleInputCard;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FigureServiceImpl implements FigureService {
    private static FigureCollections figureCollections = FigureCollectionsImpl.getInstance();

    @Override
    public void addFigure(Optional<Figure> figure) {
        if (figure.isEmpty()){
            System.out.println("\nCancelled");
        } else {
            int id = figureCollections.add(figure.get());
            System.out.println("\nFigure added, id: " + id);
        }

        ViewUtils.pressEnterToContinue();

    }

    @Override
    public void getAllFiguresPerimeters() {
        Optional<HashMap<Integer, Figure>> figuresOpt = figureCollections.findAll();
        if (figuresOpt.isEmpty()){
            System.out.println("\nThere are no figures in the collection");
        }else{
            Map<Integer, Figure> polygons = figuresOpt.get().entrySet().stream()
                    .filter(figure -> (Polygon.class.isAssignableFrom(figure.getValue().getClass())))
                    .collect(Collectors.toMap(polygon->polygon.getKey(), polygon->polygon.getValue()));

            if(polygons.isEmpty()){
                System.out.println("\nThere are no figure perimeters in the collection");
            }else {
                System.out.println();
                polygons.entrySet().stream().forEach(polygon -> {
                    System.out.println("Figure id: " + polygon.getKey());
                    System.out.println("Perimeter = " + ((Polygon)polygon.getValue()).getPerimeter());
                    System.out.println();
                });

                Double totalPerimeter = polygons.entrySet().stream()
                        .map(polygon -> ((Polygon) polygon.getValue()).getPerimeter())
                        .collect(Collectors.summingDouble(Double::doubleValue));
                System.out.println("Total perimeter = " + totalPerimeter);

            }
        }

        ViewUtils.pressEnterToContinue();
    }

    @Override
    public void getAllFiguresAreas() {
        Optional<HashMap<Integer, Figure>> figuresOpt = figureCollections.findAll();
        if (figuresOpt.isEmpty()){
            System.out.println("\nThere are no figures in the collection");
        }else{
            System.out.println();
            figuresOpt.get().entrySet().stream().forEach(figure -> {
                    System.out.println("Figure id: " + figure.getKey());
                    System.out.println("Area = " + figure.getValue().getArea());
                    System.out.println();
                });

                Double totalArea =  figuresOpt.get().entrySet().stream()
                        .map(figure -> figure.getValue().getArea())
                        .collect(Collectors.summingDouble(Double::doubleValue));
                System.out.println("Total area = " + totalArea);

            }

        ViewUtils.pressEnterToContinue();
    }

    @Override
    public void getAllFiguresCircumferences() {
        Optional<HashMap<Integer, Figure>> figuresOpt = figureCollections.findAll();
        if (figuresOpt.isEmpty()){
            System.out.println("\nThere are no figures in the collection");
        }else{
            Map<Integer, Figure> circles = figuresOpt.get().entrySet().stream()
                    .filter(circle -> (Circle.class.isAssignableFrom(circle.getValue().getClass())))
                    .collect(Collectors.toMap(circle -> circle.getKey(), circle -> circle.getValue()));

            if(circles.isEmpty()){
                System.out.println("\nThere are no circles in the collection");
            }else {
                System.out.println();
                circles.entrySet().stream().forEach(circle -> {
                    System.out.println("Figure id: " + circle.getKey());
                    System.out.println("Circumference = " + ((Circle)circle.getValue()).getLength());
                    System.out.println();
                });

                Double totalCircumference = circles.entrySet().stream()
                        .map(circle -> ((Circle) circle.getValue()).getLength())
                        .collect(Collectors.summingDouble(Double::doubleValue));
                System.out.println("Total circumference = " + totalCircumference);

            }
        }

        ViewUtils.pressEnterToContinue();
    }

    @Override
    public void updateFigure() {
        System.out.println("\nUpdate a figure\n");
        Optional<Integer> idOpt = new ViewUtils<Integer>().input("Enter ID or enter an empty string to cancel: ", Integer::parseInt);
        if(!idOpt.isEmpty()){
            Optional<Figure> figureOptional = figureCollections.findById(idOpt.get());
            if(!figureOptional.isEmpty()){
                Figure figure = figureOptional.get();
                System.out.println();
                System.out.println(figure.toString());

                Optional<Figure> updatedFigure = updateFigure(figure);
                if(!figureOptional.isEmpty()){
                    figureCollections.update(idOpt.get(), updatedFigure.get());
                    System.out.println("\nFigure is updated\n");
                }else {
                    System.out.println("\nCancelled\n");
                }

            } else System.out.println("\nFigure not found\n");
        } else System.out.println("\nCancelled\n");

        ViewUtils.pressEnterToContinue();
    }

    private Optional<Figure> updateFigure(Figure figure){
        if(figure instanceof Circle){
            return new CircleInputCard().get("\nThe circle will be updated\nComplete the following fields or enter an empty string to cancel");
        } else if (figure instanceof Rectangle) {
            return new RectangleInputCard().get("\nThe rectangle will be updated\nComplete the following fields or enter an empty string to cancel");
        } else if (figure instanceof Square) {
            return new SquareInputCard().get("\nThe square will be updated\nComplete the following fields or enter an empty string to cancel");
        } else if (figure instanceof Triangle) {
            return new TriangleInputCard().get("\nThe triangle will be updated\nComplete the following fields or enter an empty string to cancel");
        }
        return Optional.empty();
    }

    @Override
    public void removeFigure() {
        System.out.println("\nRemoving a figure from the collection\n");
        Optional<Integer> idOpt = new ViewUtils<Integer>().input("Enter ID or enter an empty string to cancel: ", Integer::parseInt);
        if(!idOpt.isEmpty()){
            Optional<Figure> figureOptional = figureCollections.findById(idOpt.get());
            if(!figureOptional.isEmpty()){
                figureCollections.deleteById(idOpt.get());
                System.out.println("\nFigure removed\n");
            }else System.out.println("\nFigure not found\n");
        } else System.out.println("\nCancelled\n");

        ViewUtils.pressEnterToContinue();
    }

    @Override
    public void printAllFigures() {
        Optional<HashMap<Integer, Figure>> figuresOpt = figureCollections.findAll();
        if (figuresOpt.isEmpty()){
            System.out.println("\nThere are no figures in the collection");
        }else{
            HashMap<Integer, Figure> animals = figuresOpt.get();
            System.out.println();
            animals.entrySet().stream().forEach(figure ->  {
                System.out.println("ID: " + figure.getKey());
                System.out.println(figure.getValue().toString());
                System.out.println();
            });
        }

        ViewUtils.pressEnterToContinue();

    }

    @Override
    public void printAllFiguresSortedByArea() {
        Optional<HashMap<Integer, Figure>> figuresOpt = figureCollections.findAll();
        if (figuresOpt.isEmpty()){
            System.out.println("\nThere are no figures in the collection");
        }else{
            HashMap<Integer, Figure> figures = figuresOpt.get();
            System.out.println();
            figures.entrySet().stream()
                    .sorted((figure1, figure2) -> (int) (figure1.getValue().getArea() - figure2.getValue().getArea()))
                    .forEach(figure ->  {
                        System.out.println("ID: " + figure.getKey());
                        System.out.println(figure.getValue().toString());
                        System.out.println();
                    });
        }

        ViewUtils.pressEnterToContinue();
    }

    @Override
    public void printFigure() {
        System.out.println("\nInformation about figure\n");
        Optional<Integer> idOpt = new ViewUtils<Integer>().input("Enter ID or enter an empty string to cancel: ", Integer::parseInt);
        if(!idOpt.isEmpty()){
            Optional<Figure> figureOptional = figureCollections.findById(idOpt.get());
            if(!figureOptional.isEmpty()){
                Figure figure = figureOptional.get();
                System.out.println();
                System.out.println(figure.toString());
            } else System.out.println("\nFigure not found\n");
        } else System.out.println("\nCancelled\n");

        ViewUtils.pressEnterToContinue();
    }
}
