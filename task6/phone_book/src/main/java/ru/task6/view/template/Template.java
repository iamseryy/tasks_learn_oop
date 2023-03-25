package ru.task6.view.template;

import ru.task6.service.NoteService;
import ru.task6.service.PersonService;
import ru.task6.service.PhoneService;
import ru.task6.service.impl.NoteServiceImpl;
import ru.task6.service.impl.PersonServiceImpl;
import ru.task6.service.impl.PhoneServiceImpl;
import ru.task6.view.ui.UserInterface;
import ru.task6.view.ui.impl.UserInterfaceImpl;

public interface Template<T> {
    PersonService personService = new PersonServiceImpl();
    PhoneService phoneService = new PhoneServiceImpl();
    NoteService notesService = new NoteServiceImpl();
    UserInterface ui = new UserInterfaceImpl();
    void output();
}