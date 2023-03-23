package controller;

import config.AppConfig;
import view.menu.impl.GeneralMenuImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppController {

    public static void start(){
        AppConfig.LOGGER.log(Level.INFO, "Application started");

        new GeneralMenuImpl().processing();
    }
}
