package controllers;

import models.Employee;
import views.EmployeeConsole;
import views.MainConsole;

public class MainController {
    EmployeController employeeController;
    EmployeeConsole employeeConsole;
    MainConsole mainConsole;

    public MainController() {
        employeeController = new EmployeController();
        employeeConsole = new EmployeeConsole();
        mainConsole = new MainConsole();
        evaluationMenu();
    }

    private void evaluationMenu() {
        String selected = "";
        while(!selected.equals("vege")) {
            selected = mainConsole.selectMenu();
            if(selected.equals("1")) {
                employeeController.index();
            }else if(selected.equals("2")) {                
                String emp = employeeConsole.addEmployee();
                employeeController.store(emp);
            }else if(selected.equals("3")) {
                Integer id = employeeConsole.editEmployee();
                String empStr = employeeController.show(id);
                Employee emp = Employee.convertToEmployee(empStr);
                employeeController.update(emp);
            }else if(selected.equals("4")) {
                Integer id = employeeConsole.deleteId();
                employeeController.delete(id);
            }else {
                System.out.println("Vége...");
                System.exit(0);
            }
        }

    }
}
