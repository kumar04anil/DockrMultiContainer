package com.aks.dokr.controller;

import com.aks.dokr.entity.Employee;
import com.aks.dokr.entity.EmployeeResponse;
import com.aks.dokr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable long id) {
        Optional<Employee> resources = employeeService.findById(id);
        return resources.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

        @PostMapping({"/create"})
        public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee employee) {
            EmployeeResponse response = this.employeeService.createEmployee(employee);
                return response.isStatus() ? new ResponseEntity(response, HttpStatus.CREATED) : new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
