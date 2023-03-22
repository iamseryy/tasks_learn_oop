package view.menu;

import view.menu.impl.CompanyConfigurationMenuImpl;
import view.menu.impl.GeneralMenuImpl;
import view.template.impl.ExitTemplate;
import view.template.impl.HireTemplate;
import view.template.impl.PrintPersonTemplate;
import view.template.impl.PrintPersonsTemplate;
import java.util.Arrays;
import java.util.List;

public interface GeneralMenu {

    String header = "\nCompany\n";
    List<MenuItem> generalMenuItems = Arrays.asList(
            new MenuItem[] {
                    new MenuItem("1 Print information about employees", () -> new PrintPersonsTemplate().output()),
                    new MenuItem("2 Print detail information about employee", () -> new PrintPersonTemplate().output()),
                    new MenuItem("3 Hire an employee", () -> new HireTemplate().output()),
                    new MenuItem("4 Company configuration", () -> new CompanyConfigurationMenuImpl().processing()),
                    new MenuItem("5 Exit", () -> new ExitTemplate().output())
            }
    );
}
