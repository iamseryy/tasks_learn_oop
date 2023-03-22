package repository.impl;

import config.AppConfig;
import model.Person;
import repository.Persons;
import utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PersonsImpl implements Persons {
    private static Optional<HashSet<Person>> persons = initCollection();

    private static PersonsImpl instance;

    private PersonsImpl(){}

    public static PersonsImpl getInstance() {
        if (instance == null) {
            instance = new PersonsImpl();
        }
        return instance;
    }

    @Override
    public int add(Object entity) {
        return 0;
    }

    @Override
    public Optional<Person> findById(int id) {
        if (this.persons.isEmpty()){
            return Optional.empty();
        }

        return this.persons.get().stream().filter(person -> person.id() == id).findAny();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Optional<HashSet<Person>> findAll() {
        return this.persons;
    }

    private static Optional<HashSet<Person>> initCollection() {
        HashSet<Person> people = new HashSet<>();
        ArrayList<String> data = FileUtils.readFile(AppConfig.getProperty("file.persons"));

        if (data.isEmpty()){
            return Optional.empty();
        }

        for (String line: data) {
            String[] values = line.split(";");
            int id = Integer.parseInt(values[0]);
            String[] fullname = values[1].split(" ");
            String name = fullname[1];
            String surname = fullname[0];
            String patronymic = "";

            if (fullname.length == 3){
                patronymic = fullname[2];
            }

            String[] nums = values[2].trim().split("-");
            int day = Integer.parseInt(nums[0]);
            int month = Integer.parseInt(nums[1]);
            int year = Integer.parseInt(nums[2]);
            Calendar date = new GregorianCalendar(year, month - 1, day);
            String address = values[3];
            String phoneNumber = values[4];

            people.add(new Person(id, name, surname, patronymic, date, address, phoneNumber));
        }

        return Optional.ofNullable(people);
    }


}
