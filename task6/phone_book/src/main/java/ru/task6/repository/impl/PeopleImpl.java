package ru.task6.repository.impl;

import ru.task6.config.AppConfig;
import ru.task6.model.Person;
import ru.task6.repository.People;
import ru.task6.utils.FileUtils;

import java.util.*;

public class PeopleImpl implements People {
    private static HashSet<Person> people = initCollection();

    private static PeopleImpl instance;

    private PeopleImpl(){}

    public static PeopleImpl getInstance() {
        if (instance == null) {
            instance = new PeopleImpl();
        }
        return instance;
    }

    @Override
    public int add(Object entity) {
        this.people.add((Person) entity);
        FileUtils.writeFile("\n" + ((Person) entity).toString(), AppConfig.getProperty("file.people"), true);
        return ((Person) entity).id();
    }

    @Override
    public Optional<Person> findById(int id) {
        return this.people.stream().filter(person -> person.id() == id).findAny();
    }

    @Override
    public void delete(Object entity) {
        this.people.remove((Person) entity);
        var data = new StringBuilder();
        this.people.stream()
                .sorted((person1, person2) -> person1.id() - person2.id())
                .forEach(person -> data.append(person.toString() + "\n"));
        data.deleteCharAt(data.length()-1);
        FileUtils.writeFile(data.toString(), AppConfig.getProperty("file.people"), false);
    }

    @Override
    public HashSet<Person> findAll() {
        return this.people;
    }

    private static HashSet<Person> initCollection() {
        HashSet<Person> people = new HashSet<>();
        ArrayList<String> data = FileUtils.readFile(AppConfig.getProperty("file.people"));

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

            people.add(new Person(id, name, surname, patronymic, date, address));
        }

        return people;
    }
}
