package application;

import java.util.Arrays;

public class EmployeeBook {
    private String name;
    private String patronymic;
    private String surname;
    private double salary;
    private int department;
    static int count;
    private final int id;
    private EmployeeBook[] storage = new EmployeeBook[5];


    //Constructor
    public EmployeeBook(String name, String patronymic, String surname, int salary, int department) {
        count++;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.id = count;

    }

    public EmployeeBook() {
        this.id = count;
    }

    public void addEmployee(String name, String patronymic, String surname, int salary, int department) {
        EmployeeBook newEmployee = new EmployeeBook(name = name, patronymic = patronymic, surname = surname, salary = salary, department = department);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = newEmployee;
                break;
            }
        }

    }


    public double maxSalary() {
        double result = 0;
        double[] max = new double[storage.length];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                continue;
            } else {
                max[i] = storage[i].getSalary();
            }

        }
        result = Arrays.stream(max).max().getAsDouble();
        return result;
    }

    public double maxSalary(EmployeeBook[] storage) {
        double result = 0;
        double[] max = new double[storage.length];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                continue;
            } else {
                max[i] = storage[i].getSalary();
            }

        }
        result = Arrays.stream(max).max().getAsDouble();
        return result;
    }

    public double minSalary() {
        double result = 0;
        double[] min = new double[storage.length];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                min[i] = storage[i].getSalary();
            }
        }
        Arrays.sort(min);
        for (int i = 0; i < min.length; i++) {
            if (min[i] > 0) {
                result = min[i];
                break;
            }
        }
        return result;
    }

    public double minSalary(EmployeeBook[] storage) {
        double result = 0;
        double[] min = new double[storage.length];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                min[i] = storage[i].getSalary();
            }
        }
        Arrays.sort(min);
        for (int i = 0; i < min.length; i++) {
            if (min[i] > 0) {
                result = min[i];
                break;
            }
        }
        return result;
    }

    public double averageSalary() {//TODO
        double avarage = monthlySalary() / count;
        return avarage;
    }

    public double averageSalaryDep(int department) {
        double avarage = 0;
        int count = 0;
        EmployeeBook[] dep = filterDep(department);
        for (int i = 0; i < dep.length; i++) {
            if (dep[i] != null) {
                count++;
                avarage += dep[i].getSalary();
            }
        }
        avarage = avarage / count;

        return avarage;
    }

    public double monthlySalary() {
        double result = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                result = result + storage[i].getSalary();
            }
        }
        return result;
    }

    public void info() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                System.out.print(storage[i].getName() + " ");
                System.out.print(storage[i].getSurname() + " ");
                System.out.println(storage[i].getPatronymic() + " ");
            }

        }
    }

    public void infoDep(int department) {
        EmployeeBook[] tmp = filterDep(department);

        for (int i = 0; i < storage.length; i++) {
            if (tmp[i] != null) {
                System.out.print(tmp[i].getName() + " ");
                System.out.print(tmp[i].getSurname() + " ");
                System.out.print(tmp[i].getPatronymic() + " ");
                System.out.print("Зарплата: " + tmp[i].getSalary() + " ");
                System.out.println("ID: " + tmp[i].getId() + " ");
            }
        }
    }

    public void allInfo() {
        for (int i = 0; i < storage.length; i++) {
            System.out.println(storage[i]);
        }
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


    public EmployeeBook[] indexSalary(double indexSalary) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                EmployeeBook[] employee = storage[i].setSalary(storage[i].getSalary() * indexSalary);
            }
        }
        return storage;
    }

    public EmployeeBook[] indexSalaryDep(int department, double indexSalary) {
        EmployeeBook[] tmp = filterDep(department);
        for (int i = 0; i < storage.length; i++) {
            if (tmp[i] != null) {
                EmployeeBook[] employee = storage[i].setSalary(storage[i].getSalary() * indexSalary);
                System.out.println(tmp[i]);
            }

        }
        return storage;
    }

    public EmployeeBook[] filterDep(int department) {
        EmployeeBook[] filter = new EmployeeBook[storage.length];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                continue;
            } else if (storage[i].getDepartment() == department) {
                filter[i] = storage[i];
            }

        }
        return filter;
    }

    public void employeeWithMoreSalary(int salary) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getSalary() > salary) {
                    System.out.println(storage[i]);
                }
            }
        }

    }

    public void employeeWithLessSalary(int salary) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getSalary() <= salary) {
                    System.out.println(storage[i]);
                }
            }
        }

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

    public EmployeeBook[] setSalary(double salary) {
        this.salary = salary;
        return new EmployeeBook[0];
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
