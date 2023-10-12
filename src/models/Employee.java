package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Employee {
    Integer id;
    String name;
    String city;
    String salary;
    public Employee() {
    }
    public Employee(String name, String city, String salary) {
        this.name = name;
        this.city = city;
        this.salary = salary;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public static Employee convertToEmployee(String text) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Employee emp = gson.fromJson(text, Employee.class);
        return emp;
    }
    public static String convertToJson(Employee emp) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String text = gson.toJson(emp);
        return text;
    }
}
