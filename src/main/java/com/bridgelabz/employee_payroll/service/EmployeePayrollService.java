package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employee_payroll.exception.EmployeePayrollException;
import com.bridgelabz.employee_payroll.model.Employee;
import com.bridgelabz.employee_payroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    private EmployeePayrollRepository employeeRepository;

    public List<Employee> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeePayrollDataById(long employeeId) {
        return employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with Employee ID " + employeeId + " does not exist!"));
    }

    public Employee createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        Employee employee = null;
        employee = new Employee(employeePayrollDTO);
        log.debug("Employee Data: " + employee.toString());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeePayrollData(long employeeId, EmployeePayrollDTO employeePayrollDTO) {
        Employee employee = this.getEmployeePayrollDataById(employeeId);
        employee.updateEmployeePayrollData(employeePayrollDTO);
        return employeeRepository.save(employee);
    }

    public void deleteEmployeePayrollData(long employeeId) {
        Employee employee = this.getEmployeePayrollDataById(employeeId);
        employeeRepository.delete(employee);
    }
}