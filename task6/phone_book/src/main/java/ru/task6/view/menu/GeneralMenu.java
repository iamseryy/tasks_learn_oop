package ru.task6.view.menu;

import ru.task6.view.template.impl.*;

import java.util.Arrays;
import java.util.List;

public interface GeneralMenu {
    String header = "\nPhone Book\n";
    List<MenuItem> generalMenuItems = Arrays.asList(
            new MenuItem[] {
                    new MenuItem("1 Print all sorted names of people", () -> new SortedPeopleOutputTemplate().output()),
                    new MenuItem("2 Print detailed information about person", () -> new DetailedPersonOutputTemplate().output()),
                    new MenuItem("3 Find person by name", () -> new FindPersonByNameTemplate().output()),
                    new MenuItem("4 Find person by phone number", () -> new FindPersonByPhoneNumberTemplate().output()),
                    new MenuItem("5 Add contact", () -> new AddContactTemplate().output()),
                    new MenuItem("6 Remove contact", () -> new RemoveContactTemplate().output()),
                    new MenuItem("7 Exit", () -> new ExitTemplate().output())
            }
    );
}
