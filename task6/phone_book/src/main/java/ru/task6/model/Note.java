package ru.task6.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public record Note(int personId, String note) {
    @Override
    public String toString() {
        return  personId + ";" +
                note;
    }
}
