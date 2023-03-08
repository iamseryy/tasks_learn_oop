package ru.task2.controller;

import ru.task2.model.Cat;
import ru.task2.model.Zoo;
import ru.task2.view.GeneralMenu;

import java.util.GregorianCalendar;
import java.util.HashMap;


public class AppController {
    public static void start(){
        var generalMenu = GeneralMenu.getInstance();
        int item = generalMenu.getMenuItemFromUser();
        switch (item){
            case 1:{
                System.out.println();
            }
            case 2:{

            }
            case 3: return;
        }




        var zoo = new Zoo(new HashMap<>());

        var cat = new Cat(40, 7, "blue", "barsik", "Siberian cat", true,
                "dark brown", new GregorianCalendar(2020, 3, 10), true);

        zoo.addAnimal(cat);

        System.out.println(zoo);
    }
}
