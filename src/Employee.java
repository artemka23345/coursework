/*  1. Создать класс Employee, который содержит информацию о Ф.И.О., отделе и зарплате сотрудника. Отделы для простоты должны быть названы от 1 до 5.
  2. Добавить статическую переменную-счетчик, которая будет отвечать за id.
  3. Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое значение.
  4. Добавить возможность получать значения полей из Employee (геттеры) для всех полей.
  5. Добавить возможность устанавливать значения полей отдела и зарплаты (сеттеры).
  6. По умолчанию все поля должны передавать через конструктор (кроме id) и заполняться в нем (включая id, который нужно получить из счетчика).
  7. Создать внутри класса с методом main поле типа Employee[10], которое будет выполнять роль «хранилища» для записей о сотрудниках.
  8. Создать статические методы, которые будут взаимодействовать с массивом и предоставлять результат:

  1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
  2. Посчитать сумму затрат на зарплаты в месяц.
  3. Найти сотрудника с минимальной зарплатой.
  4. Найти сотрудника с максимальной зарплатой.
  5. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
  6. Получить Ф. И. О. всех сотрудников (вывести в консоль).
  */

import java.util.Arrays;

public class Employee {
    private String name;
    private String patronymic;
    private String surname;
    private double salary;
    private int department;
    static int count;
    private final int id;

    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivan", "Ivanovich", "Ivanov", 40000, 1);
        Employee employee2 = new Employee("Sergej", "Sergeevich", "Nikolaev", 32000, 1);
        Employee employee3 = new Employee("Svetlana ", "Dmitreevna ", "Petrova", 70000, 3);
        Employee employee4 = new Employee("Oleg ", "Evgen'evich ", "Sergeev", 70000, 4);
        Employee employee5 = new Employee("Tat'yana ", "Gennad'evna ", "Antonova", 70000, 5);

        Employee[] storage = new Employee[]{
                employee1,employee2,employee3,employee4,employee5};



        info(storage);
        allInfo(storage);
        indexSalary(storage,1.2);
        allInfo(storage);

        System.out.println("Зарплатный фонд: " + monthlySalary(storage));
        System.out.println("Минимальная зарплата: " + minSalary(storage));
        System.out.println("Максимальная зарплата: " + maxSalary(storage));
        System.out.println("Средняя зарплата: " + averageSalary(storage));

        //System.out.println(filterDep(storage, 1));
        System.out.println("Минимальная зарплата по отделу: " + minSalary(filterDep(storage,1)));



    }
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



    public static double maxSalary(Employee[] employees) {//TODO
        double result = 0;
        double[] max = new double[employees.length];
        for (int i = 0; i < employees.length; i++) {
            max[i] = employees[i].getSalary();
        }
        result = Arrays.stream(max).max().getAsDouble();
        return result;
    }

    public static double minSalary(Employee[] employees) {//TODO
        double result = 0;
        double[] min = new double[employees.length];
        for (int i = 0; i < employees.length; i++) {
            min[i] = employees[i].getSalary();
        }
        result = Arrays.stream(min).min().getAsDouble();
        return result;
    }

    public static double averageSalary(Employee[] employees){
        double avarage = monthlySalary(employees) / count;
        return avarage;
    }

    public static double monthlySalary(Employee[] employees) {
        double result = 0;
        for (int i = 0; i < employees.length; i++) {
            result = result + employees[i].getSalary();
        }
        return result;
    }

    public static void info(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.print(employees[i].getName() + " ");
            System.out.print(employees[i].getSurname() + " ");
            System.out.println(employees[i].getPatronymic() + " ");

        }
    }
    public static void allInfo(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
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


    public static Employee[] indexSalary(Employee[] employees, double indexSalary){
        for (int i = 0; i < employees.length; i++) {
            Employee[] employee =  employees[i].setSalary(employees[i].getSalary() * indexSalary);
        }
        return employees;
    }

    public static Employee[] filterDep(Employee[] employees, int department){
        int count = 0;
        Employee[] filter = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department ) {
                filter[i] = employees[i];
            }
            if(filter[i] != null){
                count++;
            }
        }
        Employee[] filterNotNull = new Employee[count];
        for (int i = 0; i < filterNotNull.length; i++) {
            if (filter[i] != null ) {
                filterNotNull[i] = filter[i];
            }
        }
        return filterNotNull;
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
