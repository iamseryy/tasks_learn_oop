package ru.task6.view.menu.impl;

import ru.task6.view.menu.GeneralMenu;
import ru.task6.view.menu.Menu;

public class GeneralMenuImpl extends Menu implements GeneralMenu {
    public void processing() {
        super.processing(header, generalMenuItems);
    }
}