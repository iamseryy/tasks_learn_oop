package ru.task3.controller;


import ru.task3.service.FigureService;
import ru.task3.service.impl.FigureServiceImpl;
import ru.task3.view.inputcard.impl.CircleInputCard;
import ru.task3.view.inputcard.impl.RectangleInputCard;
import ru.task3.view.inputcard.impl.SquareInputCard;
import ru.task3.view.inputcard.impl.TriangleInputCard;
import ru.task3.view.menu.Menu;
import ru.task3.view.menu.impl.MenuImpl;
import ru.task3.view.menu.impl.MenuItem;
import java.util.ArrayList;


public class AppController {
    private final static FigureService figureService = new FigureServiceImpl();
    private final static ArrayList<MenuItem> generalMenuItems= new ArrayList<>();
    private final static ArrayList<MenuItem> addAnimalMenuItems= new ArrayList<>();
    private final static Menu generalMenu = new MenuImpl("\nFigures Service\n", generalMenuItems);
    private final static Menu addAnimalMenu = new MenuImpl("\nFigure to add\n", addAnimalMenuItems);

    static {
        generalMenuItems.add(new MenuItem("1 Print information about figures", () -> figureService.printAllFigures()));
        generalMenuItems.add(new MenuItem("2 Print information about figures sorting by area", () -> figureService.printAllFiguresSortedByArea()));
        generalMenuItems.add(new MenuItem("3 Print detail information about figure", () -> figureService.printFigure()));
        generalMenuItems.add(new MenuItem("4 Add a figure to the collection", () -> runAddAnimalMenu()));
        generalMenuItems.add(new MenuItem("5 Figure change", () -> figureService.updateFigure()));
        generalMenuItems.add(new MenuItem("6 Remove a figure from the collection", () -> figureService.removeFigure()));
        generalMenuItems.add(new MenuItem("7 Calculate all perimeters", () -> figureService.getAllFiguresPerimeters()));
        generalMenuItems.add(new MenuItem("8 Calculate all areas", () -> figureService.getAllFiguresAreas()));
        generalMenuItems.add(new MenuItem("9 Calculate all circumferences", () -> figureService.getAllFiguresCircumferences()));
        generalMenuItems.add(new MenuItem("10 Exit", () -> exit()));

        addAnimalMenuItems.add(new MenuItem("1 Circle", () -> figureService.addFigure(
                new CircleInputCard().get("\nThe circle will be added\nComplete the following fields or enter an empty string to cancel"))));
        addAnimalMenuItems.add(new MenuItem("2 Rectangle", () -> figureService.addFigure(
                new RectangleInputCard().get("\nThe rectangle will be added\nComplete the following fields or enter an empty string to cancel"))));
        addAnimalMenuItems.add(new MenuItem("3 Square", () -> figureService.addFigure(
                new SquareInputCard().get("\nThe square will be added\nComplete the following fields or enter an empty string to cancel"))));
        addAnimalMenuItems.add(new MenuItem("4 Triangle", () -> figureService.addFigure(
                new TriangleInputCard().get("\nThe triangle will be added\nComplete the following fields or enter an empty string to cancel"))));
        addAnimalMenuItems.add(new MenuItem("5 Back", () -> back()));
    }

    public static void start(){
        runGeneralMenu();
    }

    private static void runGeneralMenu(){
        generalMenu.processing();
    }

    private static void runAddAnimalMenu(){
        addAnimalMenu.processing();
    }

    private static void exit(){
        System.out.println("\nSee you soon");
    }

    private static void back(){
        //some action
    }
}
