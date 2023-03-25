package ru.task6.utils;

import ru.task6.config.AppConfig;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class FileUtils {
    public static ArrayList<String> readFile(File file){
        var data = new ArrayList<String>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file));){
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e){
            AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return data;
    }

    public static void writeFile(String data, File file, boolean append){
        try (FileWriter writer = new FileWriter(file, append);){
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }
}