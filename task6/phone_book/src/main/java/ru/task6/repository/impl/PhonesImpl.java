package ru.task6.repository.impl;

import ru.task6.repository.Phones;

import java.util.HashSet;
import java.util.Optional;

public class PhonesImpl implements Phones {
    @Override
    public int add(Object entity) {
        return 0;
    }

    @Override
    public Optional findById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Optional<HashSet> findAll() {
        return Optional.empty();
    }
}
