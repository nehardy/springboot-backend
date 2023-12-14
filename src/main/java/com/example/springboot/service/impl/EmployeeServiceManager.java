package com.example.springboot.service.impl;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.requestVO.EmployeeRequestBodyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class EmployeeServiceManager {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Boolean saveEmployee(EmployeeRequestBodyVO employee) {
        Employee employee1 = new Employee();
        employee1.setEmail(employee.getEmail());
        employee1.setFistName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());

        employeeRepository.save(employee1);
        return true;
    }

    public List<Employee> getDetails() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getDetailsById(Long id) {
        Optional<Employee> employeeDetails = employeeRepository.findById(id);
        return employeeDetails;
    }

    public Boolean updateEmployee(Long id, EmployeeRequestBodyVO employeeRequestBodyVO) {
        if(employeeRepository.existsById(id)) {
            Optional<Employee> e = employeeRepository.findById(id);
            Employee emp = e.get();
            emp.setFistName(employeeRequestBodyVO.getFirstName());
            emp.setLastName(employeeRequestBodyVO.getLastName());
            emp.setEmail(employeeRequestBodyVO.getEmail());
            employeeRepository.save(emp);

            return true;
        }
        else {
            return false;
        }

    }
}
