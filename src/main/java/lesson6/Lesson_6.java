package lesson6;

import lesson6.Title.Titles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Удален импорт static java.lang.StringTemplate.STR;

public class Lesson_6 {

    static HashMap<Titles, Integer> salary = new HashMap<>();

    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        fillInSalary();
        createEmployees();

        for (Employee emp : employees) {
            emp.getTitle().performSpecificDuty(emp);
        }
    }

    private static void fillInSalary() {
        salary.put(Titles.MANAGER, 10000);
        salary.put(Titles.CLERK, 3000);
        salary.put(Titles.ACCOUNTANT, 5000);
    }

    static void createEmployees() {
        createManagers();
        createClerks();
        createAccountants();
    }

    private static void createManagers() {
        Employee aTremblay = new Employee("Alex Tremblay", "M001", Titles.MANAGER, LocalDate.of(1980, 3, 15), salary.get(Titles.MANAGER), "Toronto");
        employees.add(aTremblay);
    }

    private static void createAccountants() {
        Employee mSmith = new Employee("Michael Smith", "A001", Titles.ACCOUNTANT, LocalDate.of(1988, 4, 3), salary.get(Titles.ACCOUNTANT), "Ottawa");
        employees.add(mSmith);

        Employee jBrown = new Employee("Jessica Brown", "A002", Titles.ACCOUNTANT, LocalDate.of(1985, 6, 19), salary.get(Titles.ACCOUNTANT), "Edmonton");
        employees.add(jBrown);

        Employee kLee = new Employee("Kevin Lee", "A003", Titles.ACCOUNTANT, LocalDate.of(1993, 9, 25), salary.get(Titles.ACCOUNTANT), "Winnipeg");
        employees.add(kLee);

        Employee oWhite = new Employee("Olivia White", "A004", Titles.ACCOUNTANT, LocalDate.of(1987, 12, 12), salary.get(Titles.ACCOUNTANT), "Quebec City");
        employees.add(oWhite);

        Employee rJones = new Employee("Ryan Jones", "A005", Titles.ACCOUNTANT, LocalDate.of(1991, 7, 30), salary.get(Titles.ACCOUNTANT), "Halifax");
        employees.add(rJones);
    }

    private static void createClerks() {
        Employee sMacDonald = new Employee("Sarah MacDonald", "C001", Titles.CLERK, LocalDate.of(1992, 11, 22), salary.get(Titles.CLERK), "Vancouver");
        employees.add(sMacDonald);

        Employee dMiller = new Employee("David Miller", "C002", Titles.CLERK, LocalDate.of(1995, 8, 7), salary.get(Titles.CLERK), "Montreal");
        employees.add(dMiller);

        Employee eChen = new Employee("Emily Chen", "C003", Titles.CLERK, LocalDate.of(1990, 1, 10), salary.get(Titles.CLERK), "Calgary");
        employees.add(eChen);
    }
}

class Title {

    public enum Titles {
        MANAGER, CLERK, ACCOUNTANT;

        public void performSpecificDuty(Employee emp) {
            emp.toString(emp);
            emp.receiveSalary(emp.name);
            if (emp.title == MANAGER) {
                Manager.hireEmployee(emp.name);
                Manager.fireEmployee(emp.name);
            } else if (emp.title == CLERK) {
                Clerk.callCustomer(emp.name);
                Clerk.answerIncomingCall(emp.name);
            } else if (emp.title == ACCOUNTANT) {
                Accountant.openAccount(emp.name);
                Accountant.closeAccount(emp.name);
                Accountant.createReport(emp.name);
            }
        }
    }
}

class Employee {
    public String name;
    String id;
    Titles title;
    LocalDate dob;
    int salary;
    String address;

    public Employee(String name, String id, Titles title, LocalDate dob, int salary, String address) {
        this.setName(name);
        this.id = id;
        this.title = title;
        this.dob = dob;
        this.salary = salary;
        this.address = address;
    }

    void receiveSalary(String name) {
        // Заменено STR. на конкатенацию строк
        System.out.println(name + " will receive a salary.");
    }

    void toString(Employee emp) {
        // Заменено STR. на String.format() для лучшей читаемости
        System.out.println(String.format("Name:%s, Title: %s, Address: %s, Birth Date: %s, Salary:$%d.",
                emp.name, emp.title.name(), emp.address, emp.dob, emp.salary));
    }

    public void setName(String name) {
        this.name = name;
    }

    public Titles getTitle() {
        return title;
    }
}

class Manager extends Employee {

    public Manager(String name, String id, Titles title, LocalDate dob, int salary, String address) {
        super(name, id, title, dob, salary, address);
    }

    public static void hireEmployee(String name) {
        // Заменено STR. на конкатенацию строк
        System.out.println("Manager " + name + " will hire an employee.");
    }

    public static void fireEmployee(String name) {
        // Заменено STR. на конкатенацию строк
        System.out.println("Manager " + name + " will fire an employee.");
    }
}

class Clerk extends Employee {

    public Clerk(String name, String id, Titles title, LocalDate dob, int salary, String address) {
        super(name, id, title, dob, salary, address);
    }

    public static void callCustomer(String name) {
        // Заменено STR. на конкатенацию строк
        System.out.println("Clerk " + name + " will call a customer.");
    }

    public static void answerIncomingCall(String name) {
        // Заменено STR. на конкатенацию строк
        System.out.println("Clerk " + name + " will answer the incoming call.");
    }
}

class Accountant extends Employee {

    public Accountant(String name, String id, Titles title, LocalDate dob, int salary, String address) {
        super(name, id, title, dob, salary, address);
    }

    public static void openAccount(String name) {
        // Заменено STR. на конкатенацию строк
        System.out.println("Accountant " + name + " will open an account.");
    }

    public static void closeAccount(String name) {
        // Заменено STR. на конкатенацию строк
        System.out.println("Accountant " + name + " will close an account.");
    }

    public static void createReport(String name) {
        // Заменено STR. на конкатенацию строк
        System.out.println("Accountant " + name + " will create a report.");
    }
}
