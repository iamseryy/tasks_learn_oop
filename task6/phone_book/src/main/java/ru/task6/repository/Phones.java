package ru.task6.repository;

import ru.task6.model.Phone;

import java.util.HashSet;
import java.util.Optional;

public interface Phones extends DataBase{
    HashSet<Phone> findAllByPersonId(int personId);
    void deletePhonesByPersonId(int personId);
}
