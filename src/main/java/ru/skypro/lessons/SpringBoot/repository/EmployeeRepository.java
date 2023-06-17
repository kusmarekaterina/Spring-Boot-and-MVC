package ru.skypro.lessons.SpringBoot.repository;

import ru.skypro.lessons.SpringBoot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();

    public Optional<Employee> findById(int id);

    Employee addEmployee(Employee employee);

    void putEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
