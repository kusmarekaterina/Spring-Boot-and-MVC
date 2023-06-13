package ru.skypro.lessons.SpringBoot.repository;

import org.springframework.stereotype.Component;
import ru.skypro.lessons.SpringBoot.model.Employee;

import java.util.Collections;
import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List <Employee> EMPLOYEES = List.of(
            new Employee("Irina", 85000),
            new Employee("Sonya", 91000),
            new Employee("Ivan", 67000),
            new Employee("Pavel", 75000),
            new Employee("Polina", 55000)
    );
    @Override
    public List <Employee> getAllEmployees() {
        return Collections.unmodifiableList(EMPLOYEES);
    }

}
