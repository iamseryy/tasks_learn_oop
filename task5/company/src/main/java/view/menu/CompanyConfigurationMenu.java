package view.menu;

import view.template.impl.ExitTemplate;
import view.template.impl.PositionsTemplate;
import java.util.Arrays;
import java.util.List;

public interface CompanyConfigurationMenu {
    String header = "\nCompany configuration\n";
    List<MenuItem> configurationMenuItems = Arrays.asList(
            new MenuItem[] {
                    new MenuItem("1 Positions", () -> new PositionsTemplate().output()),
                    new MenuItem("2 Back", () -> new ExitTemplate().output())
            }
    );
}
