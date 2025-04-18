package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employee_payroll.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getEmployeePayrollData();

    Employee getEmployeePayrollDataById(long employeeId);

    Employee createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    Employee updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(long employeeId);
}