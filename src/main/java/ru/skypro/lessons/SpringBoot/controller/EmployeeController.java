package ru.skypro.lessons.SpringBoot.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.SpringBoot.dto.EmployeeDTO;
import ru.skypro.lessons.SpringBoot.model.Employee;
import ru.skypro.lessons.SpringBoot.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping ("/salary/sum")
    public int findSalarySum () {
        return employeeService.findSalarySum();
    }

    @GetMapping("/salary/max")
    public Employee findEmployeeWithMaxSalary() {
        return employeeService.findEmployeeWithMaxSalary();
    }

    @GetMapping("/salary/min")
    public Employee findEmployeeWithMinSalary() {
        return employeeService.findEmployeeWithMinSalary();
    }

    @GetMapping("/high-salary")
    public List<Employee> highSalary() {
        return employeeService.highSalary();
    }

    @PostMapping("/")
    public void create(@RequestBody List<Employee> employeeList){
        employeeService.create(employeeList);
    }

    @PutMapping("/{id}")
    public void putEmployeeById (@RequestBody Employee employee, @PathVariable String id) {
        employeeService.putEmployeeById(Integer.parseInt(id), employee);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById (@PathVariable (required = false) String id) {
        return employeeService.findEmployeeById(Integer.parseInt(id));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById (@PathVariable String id) {
        employeeService.deleteEmployeeById(Integer.parseInt(id));
    }

    @GetMapping("/salaryHigherThan")
    public List<Employee> findEmployeeWithSalaryHigherThan(@RequestParam int salary){
        return employeeService.findEmployeeWithSalaryHigherThan(salary);
    }

    @GetMapping ("/withHighestSalary")
    public List<EmployeeDTO> withHighestSalary() {
        return employeeService.withHighestSalary();
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> findEmployeesByPosition (@PathVariable String position){
        return employeeService.findEmployeeByPosition(position);
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeDTO findEmployeeFullInfo(@PathVariable int id) {
        return employeeService.findEmployeeFullInfo(id);
    }

    @GetMapping("/page")
    public List<EmployeeDTO> findEmployeesFromPage(@RequestParam(required = false, defaultValue = "0") int page) {
        return employeeService.findEmployeesFromPage(page);
    }

}
