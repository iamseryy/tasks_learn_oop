package ru.task2.view;

import java.util.*;

public class GeneralMenu extends Menu{
    private static GeneralMenu instance;
    private static TreeMap<Integer, String> menuItems;

    static {
        menuItems.put(1, "Print information about animals");
        menuItems.put(2, "Add an animal to the zoo");
        menuItems.put(3, "Exit");
    }

    private GeneralMenu(){}

    public static GeneralMenu getInstance() {
        if (instance == null) {
            instance = new GeneralMenu();
            instance.setMenuItems(menuItems);
        }

        return instance;
    }


//    private static TreeMap<Integer, String> menuItems = new TreeMap<>();
//
//    static {
//        menuItems.put(1, "Print information about animals");
//        menuItems.put(2, "Add an animal to the zoo");
//        menuItems.put(3, "Exit");
//    }
//
    @Override
    public void print(){
        System.out.println("\nWelcome to the zoo!\n");
        super.print();
    }

    @Override
    public int getMenuItemFromUser(){
        this.print();
        return super.getMenuItemFromUser();
    }
}
