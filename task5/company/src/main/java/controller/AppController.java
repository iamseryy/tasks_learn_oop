package controller;

import view.menu.impl.GeneralMenuImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppController {
    public static final Logger LOGGER = Logger.getLogger(AppController.class.getName());
    public static void start(){
        LOGGER.log(Level.INFO, "Application started");

        new GeneralMenuImpl().processing();
    }
}
