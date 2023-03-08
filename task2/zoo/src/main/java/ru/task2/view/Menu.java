package ru.task2.view;

import java.util.Scanner;
import java.util.TreeMap;

public abstract class Menu implements Printable{
    private TreeMap<Integer, String> menuItems;

    public TreeMap<Integer, String> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(TreeMap<Integer, String> menuItems) {
        this.menuItems = menuItems;
    }

    public int getMenuItemFromUser(){
        try (var scanner = new Scanner(System.in)){
            while (true){
                if (scanner.hasNextInt()){
                    int item = scanner.nextInt();

                    if(item > 0 && item < this.menuItems.size() + 1){
                        return item;
                    } else System.out.print("No such item! Try Again\n");

                } else {
                    System.out.print("Invalid! Try Again\n");
                    scanner.next();
                }
            }
        }
    }

    @Override
    public void print() {
        this.menuItems.entrySet().stream().forEach(item -> System.out.println(item.getKey() + " " + item.getValue()));
        System.out.print("\nChoose your option: ");
    }


}
