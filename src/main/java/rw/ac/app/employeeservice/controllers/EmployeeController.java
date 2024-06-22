package rw.ac.app.employeeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.ac.app.employeeservice.dtos.CreateEmployeeDto;
import rw.ac.app.employeeservice.dtos.UpdateEmployeeDto;
import rw.ac.app.employeeservice.models.Employee;
import rw.ac.app.employeeservice.servicesImplimentation.EmployeeServiceImp;


import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeService;

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody CreateEmployeeDto dto) throws Exception {
        return ResponseEntity.ok(employeeService.createEmployee(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @GetMapping("/getemployee/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody UpdateEmployeeDto dto, @PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(employeeService.updatEmployee(id, dto));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Employee>> getAllEmployees() throws Exception {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
