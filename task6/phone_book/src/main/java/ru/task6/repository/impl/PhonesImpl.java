package ru.task6.repository.impl;

import ru.task6.config.AppConfig;
import ru.task6.model.Phone;
import ru.task6.model.PhoneNumberType;
import ru.task6.repository.Phones;
import ru.task6.utils.FileUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PhonesImpl implements Phones {
    private static HashSet<Phone> phones = initCollection();

    private static PhonesImpl instance;

    private PhonesImpl(){}

    public static PhonesImpl getInstance() {
        if (instance == null) {
            instance = new PhonesImpl();
        }
        return instance;
    }



    @Override
    public int add(Object entity) {
        this.phones.add((Phone) entity);
        FileUtils.writeFile("\n" + ((Phone) entity).toString(), AppConfig.getProperty("file.phones"), true);
        return ((Phone) entity).personId();
    }

    @Override
    public Optional findById(int id) {
        return Optional.empty();
    }

    @Override
    public HashSet<Phone> findAllByPersonId(int personId){
        return this.phones.stream()
                .filter(phone -> phone.personId() == personId)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public HashSet<Phone> findAll() {
        return this.phones;
    }


    @Override
    public void delete(Object entity) {
        this.phones.remove((Phone) entity);
        var data = new StringBuilder();
        this.phones.stream()
                .sorted((phone1, phone2) -> phone1.personId() - phone2.personId())
                .forEach(phone -> data.append(phone.toString() + "\n"));
        data.deleteCharAt(data.length()-1);
        FileUtils.writeFile(data.toString(), AppConfig.getProperty("file.phones"), false);
    }

    @Override
    public void deletePhonesByPersonId(int personId) {
        Set<Phone> personPhones = this.phones.stream().filter(phone -> phone.personId() == personId).collect(Collectors.toSet());
        if(personPhones.isEmpty()) return;
        personPhones.stream().forEach(person -> this.phones.remove(person));
        var data = new StringBuilder();
        this.phones.stream()
                .sorted((phone1, phone2) -> phone1.personId() - phone2.personId())
                .forEach(phone -> data.append(phone.toString() + "\n"));
        data.deleteCharAt(data.length()-1);
        FileUtils.writeFile(data.toString(), AppConfig.getProperty("file.phones"), false);
    }

    private static HashSet<Phone> initCollection() {
        HashSet<Phone> phones = new HashSet<>();
        ArrayList<String> data = FileUtils.readFile(AppConfig.getProperty("file.phones"));

        for (String line: data) {
            String[] values = line.split(";");
            int personId = Integer.parseInt(values[0]);
            String phone = values[1];
            PhoneNumberType phoneNumberType = PhoneNumberType.valueOfDescription(values[2]);

            phones.add(new Phone(personId, phone, phoneNumberType));
        }

        return phones;
    }
}
