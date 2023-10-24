package application;

import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    private String name;
    private String patronymic;
    private String surname;
    private double salary;
    private int department;
    static int count;
    private final int ID;
    private EmployeeBook[] storage = new EmployeeBook[5];

    //Constructor
    private EmployeeBook(String name, String patronymic, String surname, int salary, int department) {
        count++;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.ID = count;


    }
    //Constructor
    public EmployeeBook() {
        this.ID = count;
    }
    public void addEmployee(String name, String patronymic, String surname, int salary, int department) {
        EmployeeBook newEmployee = new EmployeeBook(name, patronymic, surname, salary, department);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                try {
                    storage[i] = newEmployee;
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                break;
            }
        }

    }

    public double maxSalary() {
        double result = 0;
        double[] max = new double[storage.length];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
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
            if (storage[i] != null) {
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

    public double averageSalary() {
        double average = 0;
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                count++;
                average += storage[i].getSalary();
            }
        }
        average = average / count;

        return average;
    }

    public double averageSalaryDep(int department) {
        double average = 0;
        int count = 0;
        EmployeeBook[] dep = filterDep(department);
        for (int i = 0; i < dep.length; i++) {
            if (dep[i] != null) {
                count++;
                average += dep[i].getSalary();
            }
        }
        average = average / count;

        return average;
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
    public void info(EmployeeBook[] employeeBook) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null) {
                System.out.print("         " + employeeBook[i].getName() + " ");
                System.out.print(employeeBook[i].getSurname() + " ");
                System.out.println(employeeBook[i].getPatronymic() + " ");
            }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Double.compare(salary, that.salary) == 0 && department == that.department && ID == that.ID && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic) && Objects.equals(surname, that.surname) && Arrays.equals(storage, that.storage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, patronymic, surname, salary, department, ID);
        result = 31 * result + Arrays.hashCode(storage);
        return result;
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

    public EmployeeBook findEmployee(String name, String patronymic, String surname) {
        EmployeeBook tmp = new EmployeeBook();
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getName().equals(name) && storage[i].getPatronymic().equals(patronymic) && storage[i].getSurname().equals(surname)) {
                    tmp = storage[i];
                }
            }
        }
        return tmp;
    }

    public void deleteEmployee(String name, String patronymic, String surname) {
        EmployeeBook tmp = findEmployee(name, patronymic, surname);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].equals(tmp)) {
                    storage[i] = null;
                }
            }

        }
    }

    public void changeEmployee(String name, String patronymic, String surname, int changeSalary) {
        EmployeeBook tmp = findEmployee(name, patronymic, surname);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].equals(tmp)) {
                    storage[i].setSalary(changeSalary);
                }
            }
        }
    }

    public void changeEmployee(String name, String patronymic, String surname, int changeSalary, int changeDep) {

        EmployeeBook tmp = findEmployee(name, patronymic, surname);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].equals(tmp)) {
                    storage[i].setSalary(changeSalary);
                    storage[i].setDepartment(changeDep);
                }
            }
        }
    }
    public void findEmployeeDep(){


            for (int j = 0; j < 5; j++) {
                System.out.println("Department: " + j);
                info(filterDep(j));


            }
        }



    public int getId() {
        return ID;
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
