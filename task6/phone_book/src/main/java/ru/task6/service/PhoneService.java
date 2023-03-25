package ru.task6.service;

import ru.task6.model.Phone;

import java.util.HashSet;

public interface PhoneService {
    int addPhone(Phone phone);
    HashSet<Phone> findAllPhonesByPersonId(int personId);
    HashSet<Phone> findPhonesByPartOfNumber(String phoneNumber);
    HashSet<Phone> findAll();
    void removePhonesByPersonId(int personId);
}
