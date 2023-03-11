package ru.task2.controller;


import ru.task2.service.ZooService;
import ru.task2.service.impl.ZooServiceImpl;
import ru.task2.view.inputcard.*;
import ru.task2.view.menu.Menu;
import ru.task2.view.menu.impl.MenuItem;
import ru.task2.view.menu.impl.MenuImpl;
import java.util.ArrayList;


public class AppController {
    private final static ZooService zooService = new ZooServiceImpl();
    private final static ArrayList<MenuItem> generalMenuItems= new ArrayList<>();
    private final static ArrayList<MenuItem> addAnimalMenuItems= new ArrayList<>();
    private final static Menu generalMenu = new MenuImpl("\nWelcome to the zoo!\n", generalMenuItems);
    private final static Menu addAnimalMenu = new MenuImpl("\nAnimal to add\n", addAnimalMenuItems);

    static {
        generalMenuItems.add(new MenuItem("1 Print information about animals", () -> zooService.printAnimals()));
        generalMenuItems.add(new MenuItem("2 Print detail information about animal", () -> zooService.printDetailAnimal()));
        generalMenuItems.add(new MenuItem("3 Add an animal to the zoo", () -> runAddAnimalMenu()));
        generalMenuItems.add(new MenuItem("4 Remove an animal from the zoo", () -> zooService.removeAnimal()));
        generalMenuItems.add(new MenuItem("5 Make the animal make a sound", () -> zooService.makeAnimalSound()));
        generalMenuItems.add(new MenuItem("6 Make all animals make a sound", () -> zooService.makeAllAnimalSound()));
        generalMenuItems.add(new MenuItem("7 Let go fly", () -> zooService.letGoFly()));
        generalMenuItems.add(new MenuItem("8 Pet an animal", () -> zooService.petAnAnimal()));
        generalMenuItems.add(new MenuItem("9 Training", () -> zooService.training()));
        generalMenuItems.add(new MenuItem("10 Exit", () -> exit()));
        addAnimalMenuItems.add(new MenuItem("1 Cat", () -> zooService.addAnimal(new CatInputCard().get())));
        addAnimalMenuItems.add(new MenuItem("2 Tiger", () -> zooService.addAnimal(new TigerInputCard().get())));
        addAnimalMenuItems.add(new MenuItem("3 Dog", () -> zooService.addAnimal(new DogInputCard().get())));
        addAnimalMenuItems.add(new MenuItem("4 Wolf", () -> zooService.addAnimal(new WolfInputCard().get())));
        addAnimalMenuItems.add(new MenuItem("5 Chicken", () -> zooService.addAnimal(new ChickenInputCard().get())));
        addAnimalMenuItems.add(new MenuItem("6 Stork", () -> zooService.addAnimal(new StorkInputCard().get())));
        addAnimalMenuItems.add(new MenuItem("7 Back", () -> back()));
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
