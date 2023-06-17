package ru.skypro.lessons.SpringBoot.service;

import ru.skypro.lessons.SpringBoot.model.Employee;

import java.util.List;

public interface EmployeeService {

    int findSalarySum ();

    Employee findEmployeeWithMaxSalary();

    Employee findEmployeeWithMinSalary();

    public List <Employee> highSalary();
}
