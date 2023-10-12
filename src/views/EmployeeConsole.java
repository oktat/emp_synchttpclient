package views;

import java.util.Scanner;

import models.Employee;

public class EmployeeConsole {
    
    Scanner sc;

    public EmployeeConsole() {
        sc = new Scanner(System.in);
    }

    public String input(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public void showEmployees(String emp) {
        System.out.println(emp);
    }

    public String addEmployee() {        
        String name = input("Név: ");        
        String city = input("Település: ");        
        String salary = input("Fizetés: ");
        Employee emp = new Employee(name, city, salary);
        return Employee.convertToJson(emp);
    }

    public Integer editEmployee() {
        System.out.println("\n\nA dolgozó szerkesztése:");
        System.out.print("Azonosító: ");
        String idStr = sc.nextLine();
        return Integer.parseInt(idStr);
    }

    public String updateEmployee(Employee emp) {
        // System.out.print("[" + emp.getName() + "] Név: ");
        String name = input("[" + emp.getName() + "] Név: ");
        if(!name.isEmpty()) emp.setName(name);

        // System.out.print("[" + emp.getCity() + "] Település: ");
        String city = input("[" + emp.getCity() + "] Település: ");
        if(!city.isEmpty()) emp.setCity(city);

        // System.out.print("[" + emp.getSalary() + "] Fizetés: ");
        String salary = input("[" + emp.getSalary() + "] Fizetés: ");
        if(!salary.isEmpty()) emp.setSalary(salary);

        String res = Employee.convertToJson(emp);

        return res;
    }

    public Integer deleteId() {
        System.out.println("\n\nA dolgozó törlése:");
        System.out.print("Azonosító: ");
        String idStr = sc.nextLine();
        return Integer.parseInt(idStr);        
    }
}
