package service;

import model.Salary;
import java.util.HashSet;
import java.util.Optional;

public interface SalaryService {
    int addSalary(Salary salary);
    boolean updateSalaryByEmployeeId(int employeeId);
    Optional<Salary> findSalaryByEmployeeId(int employeeId);
    Optional<HashSet<Salary>> findAllSalary();
    boolean removeSalary(Salary salary);
}
