package ru.task6.view.menu;

import ru.task6.view.template.impl.DetailedPersonOutputTemplate;
import ru.task6.view.template.impl.ExitTemplate;
import ru.task6.view.template.impl.SortedPeopleOutputTemplate;

import java.util.Arrays;
import java.util.List;

public interface GeneralMenu {
    String header = "\nPhone Book\n";
    List<MenuItem> generalMenuItems = Arrays.asList(
            new MenuItem[] {
                    new MenuItem("1 Print all sorted names of people", () -> new SortedPeopleOutputTemplate().output()),
                    new MenuItem("2 Print detailed information about person", () -> new DetailedPersonOutputTemplate().output()),
                    new MenuItem("3 Exit", () -> new ExitTemplate().output())
            }
    );
}
