package repository.impl;

import config.AppConfig;
import model.HirePerson;
import model.Person;
import model.Position;
import model.Status;
import repository.HirePersons;
import utils.FileUtils;

import java.util.*;

public class HirePersonsImpl implements HirePersons {
    private static Optional<HashSet<HirePerson>> hirePeople = initCollection();

    private static HirePersonsImpl instance;

    private HirePersonsImpl(){}

    public static HirePersonsImpl getInstance() {
        if (instance == null) {
            instance = new HirePersonsImpl();
        }
        return instance;
    }
    @Override
    public int add(Object entity) {
        FileUtils.writeFile("\n" + ((HirePerson) entity).toString(), AppConfig.getProperty("file.hire_operations"), true);
        return ((HirePerson) entity).personId();
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

    private static Optional<HashSet<HirePerson>> initCollection() {
        HashSet<HirePerson> hirePersons = new HashSet<>();
        ArrayList<String> data = FileUtils.readFile(AppConfig.getProperty("file.hire_operations"));

        if (data.isEmpty()){
            return Optional.empty();
        }

        for (String line: data) {
            String[] values = line.split(";");
            int personId = Integer.parseInt(values[0]);
            int positionId = Integer.parseInt(values[1]);
            Status status = Status.valueOfDescription(values[2]);

            String[] nums = values[3].trim().split("-");
            int day = Integer.parseInt(nums[0]);
            int month = Integer.parseInt(nums[1]);
            int year = Integer.parseInt(nums[2]);
            Calendar date = new GregorianCalendar(year, month - 1, day);


            hirePersons.add(new HirePerson(personId, positionId, status, date));
        }

        return Optional.ofNullable(hirePersons);
    }
}
