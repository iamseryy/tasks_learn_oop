package ru.task6.service.impl;

import ru.task6.model.Phone;
import ru.task6.repository.Phones;
import ru.task6.repository.impl.PhonesImpl;
import ru.task6.service.PhoneService;

import java.util.HashSet;
import java.util.stream.Collectors;

public class PhoneServiceImpl implements PhoneService {
    private static Phones phones = PhonesImpl.getInstance();
    @Override
    public int addPhone(Phone phone) {
        return phones.add(phone);
    }

    @Override
    public HashSet<Phone> findAllPhonesByPersonId(int personId) {
        return phones.findAllByPersonId(personId);
    }

    @Override
    public HashSet<Phone> findPhonesByPartOfNumber(String phoneNumber) {
        return findAll().stream()
                .filter(phone -> (phone.phone().contains(phoneNumber)))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public HashSet<Phone> findAll() {
        return phones.findAll();
    }

    @Override
    public void removePhonesByPersonId(int personId) {
        this.phones.deletePhonesByPersonId(personId);
    }
}
