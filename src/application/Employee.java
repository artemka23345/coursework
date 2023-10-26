package application;

import java.util.Objects;

public class Employee {
    private String name;
    private String patronymic;
    private String surname;
    private double salary;
    private int department;
    static int count;
    private final int id;


    //Constructor
   public Employee(String name, String patronymic, String surname, int salary, int department) {
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
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && department == employee.department && id == employee.id && Objects.equals(name, employee.name) && Objects.equals(patronymic, employee.patronymic) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, patronymic, surname, salary, department, id);
    }


}
