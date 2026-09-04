class Employee {
    String empId;
    double salary;

    // Constructor using this to resolve naming clash
    Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    // raiseSalary using this to resolve naming clash
    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    void printSalary() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }
}

public class Main {
    public static void main(String[] args) {

        Employee[] employees = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        // Apply same bonus to every employee
        for (Employee employee : employees) {
            employee.raiseSalary(5000);
        }

        // Print final salaries
        for (Employee employee : employees) {
            employee.printSalary();
        }
    }
}
