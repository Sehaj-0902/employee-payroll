package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employee_payroll.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    public List<Employee> getEmployeePayrollData() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, new EmployeePayrollDTO("Sehaj", 45000)));
        return employeeList;
    }

    public Employee getEmployeePayrollDataById(long employeeId) {
        Employee employee = null;
        employee = new Employee(1, new EmployeePayrollDTO("Sehaj", 50000));
        return employee;
    }

    public Employee createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        Employee employee = null;
        employee = new Employee(1, employeePayrollDTO);
        return employee;
    }

    public Employee updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        Employee employee = null;
        employee = new Employee(1, employeePayrollDTO);
        return employee;
    }

    public void deleteEmployeePayrollData(long employeeId) {}
}