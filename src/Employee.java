
public class Employee {
    String name;
    String patronymic;
    String surname;
    int salary;
    int department;
    static int id;
    public Employee(String name, String patronymic, String surname, int salary, int department) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        id =+1;
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
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getDepartment() {
        return department;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Employee.id = id;
    }

    public static void main(String[] args) {



        }
    }
