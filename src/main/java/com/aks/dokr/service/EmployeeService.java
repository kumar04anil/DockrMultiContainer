package com.aks.dokr.service;

import com.aks.dokr.entity.Employee;
import com.aks.dokr.entity.EmployeeResponse;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(long id);

    EmployeeResponse createEmployee(Employee employee);
}
