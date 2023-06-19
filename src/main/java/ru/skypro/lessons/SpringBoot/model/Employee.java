package ru.skypro.lessons.SpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Employee {

    private static int count = 1;

    private String name;

    private int salary;

    private int id;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
