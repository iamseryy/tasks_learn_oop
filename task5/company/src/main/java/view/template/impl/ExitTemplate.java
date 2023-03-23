package view.template.impl;

import config.AppConfig;
import view.template.Template;

import java.util.logging.Level;

public class ExitTemplate implements Template {
    @Override
    public void output() {
        AppConfig.LOGGER.log(Level.INFO, "Application closed");
    }
}
