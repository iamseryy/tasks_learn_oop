package repository;

import model.Salary;

import java.util.HashSet;
import java.util.Optional;

public interface Salaries extends DataBase{
    Optional<Salary> findByEmployeeId(int employeeId);
}
