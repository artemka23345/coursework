package application;

public class Main {
    public static void main(String[] args) {
        EmployeeBook emp = new EmployeeBook();
        emp.addEmployee("Ivan", "Ivanovich", "Ivanov", 40000, 1);
        emp.addEmployee("Sergej", "Sergeevich", "Nikolaev", 32000, 1);
        emp.addEmployee("Svetlana", "Dmitreevna", "Petrova", 70000, 3);
        emp.addEmployee("Oleg", "Evgen'evich", "Sergeev", 70000, 4);
        emp.addEmployee("Tat'yana", "Gennad'evna", "Antonova", 70000, 5);

        emp.info();
        emp.allInfo();
        emp.indexSalary(1.1);//Повышаем зарплату на 10 процентов
        System.out.println("Зарплатный фонд: " + emp.monthlySalary());

        System.out.println("Минимальная зарплата: " + emp.minSalary());
        System.out.println("Максимальная зарплата: " + emp.maxSalary());
        System.out.println("Средняя зарплата: " + emp.averageSalary());

        System.out.println("Минимальная зарплата по отделу: " + emp.minSalary(emp.filterDep(1)));
        System.out.println("Максимальная зарплата по отделу: " + emp.maxSalary(emp.filterDep(1)));
        System.out.println("Средняя зарплата по отделу: " + emp.averageSalaryDep(1));
        emp.indexSalaryDep(1, 1.2);//Повышаем зарплату в выбранном отделе
        emp.infoDep(1); //Информация по отделам без отдела
        System.out.println("_______________________________________________________________________");
        emp.employeeWithMoreSalary(70000);
        System.out.println("_______________________________________________________________________");
        emp.employeeWithLessSalary(52800);

        System.out.println(emp.findEmployee("Oleg", "Evgen'evich", "Sergeev"));
        System.out.println("_______________________________________________________________________");
        emp.deleteEmployee("Oleg", "Evgen'evich", "Sergeev");
        emp.allInfo();
        emp.deleteEmployee("Tat'yana", "Gennad'evna", "Antonova");
        emp.allInfo();
        emp.changeEmployee("Svetlana", "Dmitreevna", "Petrova", 10);
        emp.allInfo();
        emp.changeEmployee("Svetlana", "Dmitreevna", "Petrova", 100, 4);
        emp.allInfo();



    }
}
