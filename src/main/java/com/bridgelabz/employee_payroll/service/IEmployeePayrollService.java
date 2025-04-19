package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employee_payroll.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getEmployeePayrollData();

    Employee getEmployeePayrollDataById(long employeeId);

    List<Employee> getEmployeesByDepartment(String department);

    Employee createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    Employee updateEmployeePayrollData(long employeeId, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(long employeeId);
}