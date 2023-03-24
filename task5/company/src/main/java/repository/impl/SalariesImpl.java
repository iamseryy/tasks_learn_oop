package repository.impl;

import config.AppConfig;
import model.HirePerson;
import model.Salary;
import model.Status;
import repository.Salaries;
import utils.FileUtils;

import java.util.*;
import java.util.stream.Collectors;

public class SalariesImpl implements Salaries {
    private static Optional<HashSet<Salary>> salaries = initCollection();

    private static SalariesImpl instance;

    private SalariesImpl(){}

    public static SalariesImpl getInstance() {
        if (instance == null) {
            instance = new SalariesImpl();
        }
        return instance;
    }


    @Override
    public int add(Object entity) {
        salaries.get().add((Salary) entity);
        FileUtils.writeFile("\n" + ((Salary) entity).toString(), AppConfig.getProperty("file.salary"), true);
        return ((Salary) entity).getIdEmployee();
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

    @Override
    public Optional<Salary> findByEmployeeId(int employeeId) {
        return salaries.get().stream().filter(salary -> salary.getId() == employeeId).findAny();
    }

    private static Optional<HashSet<Salary>> initCollection() {
        HashSet<Salary> salaries = new HashSet<>();
        ArrayList<String> data = FileUtils.readFile(AppConfig.getProperty("file.salary"));

        if (data.isEmpty()){
            return Optional.empty();
        }

        for (String line: data) {
            String[] values = line.split(";");
            int salaryId = Integer.parseInt(values[0]);
            int salaryValue = Integer.parseInt(values[1]);

            salaries.add(new Salary(salaryId, salaryValue));
        }

        return Optional.ofNullable(salaries);
    }

}
