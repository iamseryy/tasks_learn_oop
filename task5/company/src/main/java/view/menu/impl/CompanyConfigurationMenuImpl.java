package view.menu.impl;

import view.menu.CompanyConfigurationMenu;
import view.menu.Menu;

public class CompanyConfigurationMenuImpl  extends Menu implements CompanyConfigurationMenu {
    public void processing() {
        super.processing(header, configurationMenuItems);
    }
}
