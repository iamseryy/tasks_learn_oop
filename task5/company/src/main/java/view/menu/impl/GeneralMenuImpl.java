package view.menu.impl;

import view.menu.GeneralMenu;
import view.menu.Menu;

public class GeneralMenuImpl extends Menu implements GeneralMenu{
    public void processing() {
        super.processing(header, generalMenuItems);
    }
}
