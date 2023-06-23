package ru.skypro.lessons.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.lessons.SpringBoot.dto.EmployeeDTO;
import ru.skypro.lessons.SpringBoot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employees",
            nativeQuery = true)
    public List<Employee> getAllEmployees();

    @Query(value = "SELECT * FROM employees WHERE employee_id= :id",
            nativeQuery = true)
    public Optional<Employee> findById(@Param("id") int id);

    Employee addEmployee(Employee employee);

    void putEmployee(int id, Employee employee);

    void deleteEmployee(int id);
    @Query(value = "SELECT * FROM employee e where salary = (select MAX(salary) FROM employee e2)",
            nativeQuery = true)
    List<EmployeeDTO> employeeMaxSalary();

    List<Employee> findEmployeeByPosition_Position(String position);
}
