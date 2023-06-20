package ru.skypro.lessons.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.lessons.SpringBoot.dto.EmployeeDTO;
import ru.skypro.lessons.SpringBoot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> getAllEmployees();

    public Optional<Employee> findById(int id);

    Employee addEmployee(Employee employee);

    void putEmployee(int id, Employee employee);

    void deleteEmployee(int id);
    @Query("SELECT new ru.skypro.lessons.SpringBoot.dto.EmployeeDTO(e.id, e.name, e.salary) " +
            "FROM Employee  e left join Position p on p.id = e.position.id where e.salary = (SELECT MAX(e.salary) from  Employee e)")
    List<EmployeeDTO> employeeMaxSalary();

    List<Employee> findEmployeeByPosition_Position(String position);
}
