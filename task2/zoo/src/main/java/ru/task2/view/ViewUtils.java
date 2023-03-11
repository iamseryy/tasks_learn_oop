package ru.task2.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.Scanner;

public class ViewUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static void pressEnterToContinue(){
        System.out.println("\nPress Enter to continue");
        try{
            System.in.read();
        }
        catch(Exception e){

        }
    }

    public static Optional<Integer> inputInt(String message){
        int number = -1;

        do{
            System.out.print(message);
            String line = scanner.nextLine();
            if (line.isEmpty()){
                return Optional.empty();
            }

            try{
                number = Integer.parseInt(line);
                if (number < 1){
                    System.out.println("Invalid! It's must be an integer greater than zero. Try Again");
                }
            } catch(Exception e){
                System.out.println("Invalid! Not an integer. Try Again");
            }
        } while (number < 0);

        return Optional.ofNullable(number);
    }

    public static String inputStr(String message){
        System.out.print(message);
        String value = scanner.nextLine();
        if (value.isEmpty()){
            return "";
        }
        return value;
    }

    public static Optional<Calendar> inputDate(String message){
        while(true){
            System.out.print(message);
            String value = scanner.nextLine();
            if (value.isEmpty()){
                return Optional.empty();
            }

            String[] nums = value.trim().split("-");
            if (nums.length != 3){
                System.out.println("Invalid! Not a date format. Try Again");
                continue;
            }

            try {
                int day = Integer.parseInt(nums[0]);
                int month = Integer.parseInt(nums[1]);
                int year = Integer.parseInt(nums[2]);

                Calendar date = new GregorianCalendar(year, month - 1, day);
                return Optional.ofNullable(date);

            } catch (Exception e){
                System.out.println("Invalid! Not a date format. Try Again");
            }
        }
    }

    public static Optional<Boolean> inputBool(String message){
        while (true){
            System.out.print(message);
            String line = scanner.nextLine();
            if (line.isEmpty()){
                return Optional.empty();
            }

            if(!line.trim().equalsIgnoreCase("true") && !line.trim().equalsIgnoreCase("false")){
                System.out.println("Invalid! Try Again");
                continue;
            }

            return Optional.ofNullable(Boolean.parseBoolean(line));
        }
    }

    public static Optional<Integer> inputMenuItem(String message){
        while (true) {
            System.out.print(message);

            String line = scanner.nextLine();

            if (line.isEmpty()) {
                return Optional.empty();
            }

            try {
                int number = Integer.parseInt(line);
                return Optional.ofNullable(number);
            } catch (Exception e) {
                return Optional.empty();
            }
        }
    }

}
