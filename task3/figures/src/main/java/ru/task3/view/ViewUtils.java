package ru.task3.view;


import java.util.Optional;
import java.util.Scanner;

public class ViewUtils <T> {
    private static Scanner scanner = new Scanner(System.in);

    public static void pressEnterToContinue(){
        System.out.println("\nPress Enter to continue");
        try{
            System.in.read();
        }
        catch(Exception e){

        }
    }

    public Optional<T> input(String message, Parserable parser){
        while (true) {
            System.out.print(message);

            String line = scanner.nextLine();

            if (line.isEmpty()) {
                return Optional.empty();
            }

            try {
                T value = (T) parser.parse(line);
                return Optional.ofNullable(value);
            } catch (Exception e) {
                System.out.println("Invalid input data! Try Again");
            }
        }
    }
}
