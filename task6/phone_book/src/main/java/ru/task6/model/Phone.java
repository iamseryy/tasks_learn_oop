package ru.task6.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public record Phone(int personId, String phone, PhoneNumberType type) {
    @Override
    public String toString() {
        return  personId + ";" +
                phone + ';' +
                type.getDescription();
    }
}
