package application;

import java.util.Arrays;
import java.util.Objects;

public class Employee {
    private String name;
    private String patronymic;
    private String surname;
    private double salary;
    private int department;
    static int count;
    private final int id;

    EmployeeBook employeeBook = new EmployeeBook();


    //Constructor
    Employee(String name, String patronymic, String surname, int salary, int department) {
        count++;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.id = count;
    }
    //Constructor
    public Employee() {
        this.id = count;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", patronymic='" + getPatronymic() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", salary=" + getSalary() +
                ", department=" + getDepartment() +
                ", id=" + getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee that = (Employee) o;
        return Double.compare(salary, that.salary) == 0 && department == that.department && id == that.id && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic) && Objects.equals(surname, that.surname) && Arrays.equals(employeeBook.getStorage(), that.employeeBook.getStorage());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, patronymic, surname, salary, department, id);
        result = 31 * result + Arrays.hashCode(employeeBook.getStorage());
        return result;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public Employee[] setSalary(double salary) {
        this.salary = salary;
        return new Employee[0];
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
