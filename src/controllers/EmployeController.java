package controllers;

import java.util.Properties;

import models.Client;
import models.Config;
import models.Employee;
import views.EmployeeConsole;

public class EmployeController {
    String host;
    String endpoint;
    Client client;
    EmployeeConsole employeeConsole;

    public EmployeController() { 
        Properties properties = Config.newProperties();
        host = properties.getProperty("host");
        endpoint = "employees";
        client = new Client();
        employeeConsole = new EmployeeConsole();
    }

    public void index() {
        String url = host + endpoint;
        String res = client.get(url);
        employeeConsole.showEmployees(res);
    }
    
    public String show(Integer id) {
        String url = host + endpoint + "/" + id.toString();
        String res = client.get(url);
        return res;
    }
    
    public String store(String body) {
        String url = host + endpoint;
        return client.post(url, body);
    }
    
    public String update(Employee emp) {
        String url = host + endpoint + "/" + emp.getId().toString();
        String empJson = employeeConsole.updateEmployee(emp);
        return client.put(url, empJson);
    }

    public String delete(Integer id) {
        String url = host + endpoint + "/" + id.toString();
        return client.delete(url);
    }
}
