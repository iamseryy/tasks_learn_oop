package ru.task6.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public record Person(int id, String name, String surname, String patronymic, Calendar dateBirth, String homeAddress) {
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return  id + ";" +
                surname + ' ' +
                name + ' ' +
                patronymic + ';' +
                dateFormat.format(this.dateBirth.getTime()) + ";" +
                homeAddress;
    }
}
