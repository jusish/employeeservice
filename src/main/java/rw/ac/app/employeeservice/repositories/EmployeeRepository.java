
package rw.ac.app.employeeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.app.employeeservice.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}