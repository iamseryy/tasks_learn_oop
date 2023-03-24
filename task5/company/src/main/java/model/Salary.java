package model;

public class Salary {
    private int idEmployee;
    private int salaryValue;

    public Salary(int idEmployee, int salaryValue) {
        this.idEmployee = idEmployee;
        this.salaryValue = salaryValue;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int id) {
        this.idEmployee = id;
    }

    public int getSalaryValue() {
        return salaryValue;
    }

    public void setSalaryValue(int salaryValue) {
        this.salaryValue = salaryValue;
    }

    @Override
    public String toString() {
        return idEmployee + ";" + salaryValue;
    }
}
