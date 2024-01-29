import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {
    String employeeId;
    String name;
    int age;
    int salary;

    public Employee(String employeeId, String name, int age, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%-12s %-10s %-4d %-6d", employeeId, name, age, salary);
    }
}

class EmployeeComparator implements Comparator<Employee> {
    private String sortingParameter;

    public EmployeeComparator(String sortingParameter) {
        this.sortingParameter = sortingParameter;
    }

    @Override
    public int compare(Employee emp1, Employee emp2) {
        switch (sortingParameter) {
            case "Age":
                return Integer.compare(emp1.age, emp2.age);
            case "Name":
                return emp1.name.compareTo(emp2.name);
            case "Salary":
                return Integer.compare(emp1.salary, emp2.salary);
            default:
                throw new IllegalArgumentException("Invalid sorting parameter");
        }
    }
}

class EmployeeDatabase {
    List<Employee> employees;

    public EmployeeDatabase(List<Employee> employees) {
        this.employees = employees;
    }

    public void displaySortedData(String sortingParameter) {
        Collections.sort(employees, new EmployeeComparator(sortingParameter));
        System.out.println(String.format("%-12s %-10s %-4s %-6s", "Employee ID", "Name", "Age", "Salary"));
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

public class sort {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("161E90", "Ramu", 35, 59000));
        employees.add(new Employee("171E22", "Tejas", 30, 82100));
        employees.add(new Employee("171G55", "Abhi", 25, 100000));
        employees.add(new Employee("152K46", "Jaya", 32, 85000));

        EmployeeDatabase employeeDatabase = new EmployeeDatabase(employees);

        System.out.println("Choose sorting parameter:");
        System.out.println("1. Age");
        System.out.println("2. Name");
        System.out.println("3. Salary");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine().trim();

        String sortingParameter;
        switch (userChoice) {
            case "1":
                sortingParameter = "Age";
                break;
            case "2":
                sortingParameter = "Name";
                break;
            case "3":
                sortingParameter = "Salary";
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        employeeDatabase.displaySortedData(sortingParameter);
        scanner.close();
    }
}
