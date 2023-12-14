package com.example.springboot.controller;

import com.example.springboot.model.Employee;
import com.example.springboot.requestVO.EmployeeRequestBodyVO;
import com.example.springboot.service.impl.EmployeeServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceManager employeeService;

    @PostMapping("/postEmployeeDetails")
    public ResponseEntity<Boolean> saveEmployee(@RequestBody EmployeeRequestBodyVO employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeDetails")
    public List<Employee> getEmployeeDetails() {
        List<Employee> listOfEmployees = employeeService.getDetails();
        return listOfEmployees;
    }

    @GetMapping("/getEmployeeDetailsById/{id}")
    public Optional<Employee> getEmployeeDetailsById(@PathVariable("id") Long id) {
        Optional<Employee> employeeDetails = employeeService.getDetailsById(id);
        return employeeDetails;
    }

    @PutMapping("/updateEmployeeDetails/{id}")
    public ResponseEntity<Boolean> updateEmployeeDetails(@PathVariable("id") Long id, @RequestBody EmployeeRequestBodyVO employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.ACCEPTED);
    }
}
