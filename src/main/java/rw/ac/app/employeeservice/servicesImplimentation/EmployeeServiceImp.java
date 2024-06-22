package rw.ac.app.employeeservice.servicesImplimentation;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.ac.app.employeeservice.dtos.CreateEmployeeDto;
import rw.ac.app.employeeservice.dtos.UpdateEmployeeDto;
import rw.ac.app.employeeservice.models.Employee;
import rw.ac.app.employeeservice.repositories.EmployeeRepository;
import rw.ac.app.employeeservice.services.EmployeeService;


@Service
public class EmployeeServiceImp implements EmployeeService {
 @Autowired
 private EmployeeRepository employeeRepository;

@Override
public List<Employee> getAllEmployees() throws Exception {
    try {
        return employeeRepository.findAll();
    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception(e.getMessage());
    }
    
}

@Override
public String createEmployee(CreateEmployeeDto dto) throws Exception {
    if (dto.getFirstName() == null || dto.getLastName() == null || dto.getInstitution() ==  null || dto.getPosition() == null) {
        throw new BadRequestException("All fields are required");
    } else {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setInstitution(dto.getInstitution());
        employee.setPosition(dto.getPosition());
        employeeRepository.save(employee);

        return "Employee Created successfully";
    }
    
}

@Override
public Employee getEmployeeById(Long id) throws Exception {
    try {
        return employeeRepository.findById(id).orElseThrow(() -> new Exception("Employee not found"));
    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception(e.getMessage());
    }
}

@Override
public String deleteEmployee(Long id) throws Exception {
    try {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new Exception("User not found"));
        employeeRepository.delete(employee);
        return "Employee deleted successfully";
    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception(e.getMessage());
    }
}

@Override
public Employee updatEmployee(Long id, UpdateEmployeeDto dto) throws Exception {
    try {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new Exception("User not found"));

        String firstName = dto.getFirstName() == null ? employee.getFirstName() : dto.getFirstName();
        String lastName =  dto.getLastName() == null ? employee.getLastName() : dto.getLastName();
        String institution = dto.getInstitution() ==  null ? employee.getInstitution() : dto.getInstitution();
        String position = dto.getPosition() == null ? employee.getPosition() : dto.getPosition();
    
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setInstitution(institution);
        employee.setPosition(position);
    
        employeeRepository.save(employee);
    
        return employee;
    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception(e.getMessage());
    }
}

}
