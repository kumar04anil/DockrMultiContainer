package com.aks.dokr.service.impl;

import com.aks.dokr.entity.Employee;
import com.aks.dokr.entity.EmployeeResponse;
import com.aks.dokr.repository.EmployeeRepository;
import com.aks.dokr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeResponse createEmployee(Employee employee) {
        return new EmployeeResponse(true, employeeRepository.save(employee));
    }
}
