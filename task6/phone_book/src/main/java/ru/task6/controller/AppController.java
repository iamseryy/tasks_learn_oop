package ru.task6.controller;

import ru.task6.config.AppConfig;
import ru.task6.view.menu.impl.GeneralMenuImpl;

import java.util.logging.Level;

public class AppController {
    public static void start(){
        AppConfig.LOGGER.log(Level.INFO, "Application started");

        new GeneralMenuImpl().processing();
    }
}
