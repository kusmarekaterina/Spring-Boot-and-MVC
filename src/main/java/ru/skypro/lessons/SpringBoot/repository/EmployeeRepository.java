package ru.skypro.lessons.SpringBoot.repository;

import ru.skypro.lessons.SpringBoot.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();

}
