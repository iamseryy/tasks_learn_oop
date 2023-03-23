package view.menu;

import view.menu.impl.CompanyConfigurationMenuImpl;
import view.template.impl.*;

import java.util.Arrays;
import java.util.List;

public interface GeneralMenu {

    String header = "\nCompany\n";
    List<MenuItem> generalMenuItems = Arrays.asList(
            new MenuItem[] {
                    new MenuItem("1 Print information about employees", () -> new PrintPersonsTemplate().output()),
                    new MenuItem("2 Print detail information about employee", () -> new PrintPersonTemplate().output()),
                    new MenuItem("3 Hire an employee", () -> new HireTemplate().output()),
                    new MenuItem("4 Fire an employee", () -> new FireTemplate().output()),
                    new MenuItem("5 Company configuration", () -> new CompanyConfigurationMenuImpl().processing()),
                    new MenuItem("6 Exit", () -> new ExitTemplate().output())
            }
    );
}
