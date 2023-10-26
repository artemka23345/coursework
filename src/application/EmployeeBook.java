package application;

import java.util.Arrays;

public class EmployeeBook {
    private Employee[] storage;

    public EmployeeBook(int capacity) {
         storage = new Employee[capacity];
    }

    public void addEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee newEmployee = new Employee(name, patronymic, surname, salary, department);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = newEmployee;
                break;
            }
        }

    }
    public double maxSalary(Employee[] storage) {
        double result = 0;
        double[] max = new double[storage.length];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                max[i] = storage[i].getSalary();
            }
        }
        Arrays.sort(max);
        result = max[max.length - 1];
        return result;
    }

    public double minSalary(Employee[] storage) {
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
        Employee[] dep = filterDep(department);
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

    public void infoDep(int department) {
        Employee[] tmp = filterDep(department);

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
    public void info(Employee[] employeeBook) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null) {
                System.out.print("         " + employeeBook[i].getName() + " ");
                System.out.print(employeeBook[i].getSurname() + " ");
                System.out.println(employeeBook[i].getPatronymic() + " ");
            }
        }
    }
    public Employee[] indexSalary(double indexSalary) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                Employee[] employee = storage[i].setSalary(storage[i].getSalary() * indexSalary);
            }
        }
        return storage;
    }
    public Employee[] indexSalaryDep(int department, double indexSalary) {
        Employee[] tmp = filterDep(department);
        for (int i = 0; i < storage.length; i++) {
            if (tmp[i] != null) {
                Employee[] employee = storage[i].setSalary(storage[i].getSalary() * indexSalary);
                System.out.println(tmp[i]);
            }

        }
        return storage;
    }
    public Employee[] filterDep(int department) {
        Employee[] filter = new Employee[storage.length];
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
    public Employee findEmployee(String name, String patronymic, String surname) {
        Employee tmp = new Employee();
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
        Employee tmp = findEmployee(name, patronymic, surname);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].equals(tmp)) {
                    storage[i] = null;
                }
            }

        }
    }
    public void changeEmployee(String name, String patronymic, String surname, int changeSalary) {
        Employee tmp = findEmployee(name, patronymic, surname);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].equals(tmp)) {
                    storage[i].setSalary(changeSalary);
                }
            }
        }
    }
    public void changeEmployee(String name, String patronymic, String surname, int changeSalary, int changeDep) {

        Employee tmp = findEmployee(name, patronymic, surname);
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

    public Employee[] getStorage() {
        return storage;
    }

    public void setStorage(Employee[] storage) {
        this.storage = storage;
    }
}
