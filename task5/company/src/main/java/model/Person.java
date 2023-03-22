package model;

import java.util.Calendar;

public record Person(int id, String name, String surname, String patronymic, Calendar dateBirth, String homeAddress,
                     String phoneNumber) {}
