package ru.task1.products;

import ru.task1.products.model.*;

import java.util.GregorianCalendar;
import java.util.HashSet;

public class Program
{
    public static void main( String[] args ){

        var products = new HashSet<Product>();
        products.add(new Milk("House in the village", 90, 1, "liter", 1, 2.5,
                new GregorianCalendar(2023, 3, 15)));

        products.add(new Lemonade("Pinocchio", 60, 5, "liter", 0.5));

        products.add(new Bread("Long loaf", 80, 1, "piece",
                new GregorianCalendar(2023, 3, 10), "flour for baking"));

        products.add(new Egg("Country eggs", 100, 1, "pack",
                new GregorianCalendar(2023, 5, 20), 10));

        products.add(new Mask("Medical mask", 20, 1, "pack", 100));

        products.add(new ToiletPaper("Tenderness", 50, 2, "pack", 10, 3));

        products.add(new Diaper("Huggies", 1000, 1, "pack", 1,
                true, "4", 9, 14, "Panty diapers"));

        products.add(new Pacifier("Bibs", 1000, 2, "piece", 1, true));


        products.forEach(product -> printProduct(product));
    }

    public static void printProduct(Product product){
        System.out.println(product);
    }
}
