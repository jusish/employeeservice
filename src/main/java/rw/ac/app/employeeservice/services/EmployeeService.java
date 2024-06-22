package rw.ac.app.employeeservice.services;

import rw.ac.app.employeeservice.dtos.CreateEmployeeDto;
import rw.ac.app.employeeservice.dtos.UpdateEmployeeDto;
import rw.ac.app.employeeservice.models.Employee;

import java.util.*;
public interface EmployeeService {

    List<Employee> getAllEmployees() throws Exception;
    String createEmployee(CreateEmployeeDto dto) throws Exception;

    Employee getEmployeeById(Long id) throws Exception;

    String deleteEmployee(Long id) throws Exception;
    Employee updatEmployee(Long id, UpdateEmployeeDto dto) throws Exception;

}
