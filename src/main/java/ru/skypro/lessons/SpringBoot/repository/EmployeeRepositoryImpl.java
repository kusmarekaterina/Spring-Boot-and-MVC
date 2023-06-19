package ru.skypro.lessons.SpringBoot.repository;

import org.springframework.stereotype.Component;
import ru.skypro.lessons.SpringBoot.model.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private List <Employee> employees = List.of(
            new Employee("Irina", 85000),
            new Employee("Sonya", 91000),
            new Employee("Ivan", 67000),
            new Employee("Pavel", 75000),
            new Employee("Polina", 55000)
    );
    @Override
    public List <Employee> getAllEmployees() {
        return Collections.unmodifiableList(employees);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();

    }

    @Override
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public void putEmployee(int id, Employee employee) {
        employees.set(id, employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employees.remove(id);
    }

}
