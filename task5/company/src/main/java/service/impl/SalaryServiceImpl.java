package service.impl;

import model.Salary;
import repository.HirePersons;
import repository.Salaries;
import repository.impl.HirePersonsImpl;
import repository.impl.SalariesImpl;
import service.SalaryService;

import java.util.HashSet;
import java.util.Optional;

public class SalaryServiceImpl implements SalaryService {
    private static Salaries salaries = SalariesImpl.getInstance();

    @Override
    public int addSalary(Salary salary) {
        return salaries.add(salary);
    }

    @Override
    public boolean updateSalaryByEmployeeId(int employeeId) {
        return false;
    }

    @Override
    public Optional<Salary> findSalaryByEmployeeId(int employeeId) {
        return salaries.findByEmployeeId(employeeId);
    }

    @Override
    public Optional<HashSet<Salary>> findAllSalary() {
        return Optional.empty();
    }

    @Override
    public boolean removeSalary(Salary salary) {
        return false;
    }
}
