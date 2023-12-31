package ru.skypro.lessons.SpringBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.SpringBoot.exceptions.IdNotFoundException;
import ru.skypro.lessons.SpringBoot.model.Employee;
import ru.skypro.lessons.SpringBoot.repository.EmployeeRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryImpl employeeRepository;

    @Override
    public int findSalarySum() {
        int sumSalary = 0;
        List<Integer> salaryList = employeeRepository.getAllEmployees()
                .stream()
                .map(Employee::getSalary)
                .toList();
        for (Integer salary : salaryList) {
            sumSalary = sumSalary + salary;
        }
        return sumSalary;
    }

    @Override
    public Employee findEmployeeWithMaxSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee findEmployeeWithMinSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> highSalary() {
        int sizeRepository = employeeRepository.getAllEmployees().size();
        int averageSalary = findSalarySum() / sizeRepository;
        return employeeRepository.getAllEmployees()
                .stream()
                .filter(employee -> employee.getSalary() > averageSalary)
                .collect(Collectors.toList());

    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
    }

    @Override
    public void create(List<Employee> employeeList) {
         employeeList.stream()
         .map(employee -> new Employee(employee.getName(), employee.getSalary()))
         .map(employeeRepository::addEmployee)
         .collect(Collectors.toList());
    }

    @Override
    public void putEmployeeById (int id, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        oldEmployee.setSalary(employee.getSalary());
        oldEmployee.setName(employee.getName());
        employeeRepository.putEmployee(id, oldEmployee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> findEmployeeWithSalaryHigherThan(int salary) {
        return employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());
    }
}
