package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employee_payroll.exception.EmployeePayrollException;
import com.bridgelabz.employee_payroll.model.Employee;
import com.bridgelabz.employee_payroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    private EmployeePayrollRepository employeeRepository;

    List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeePayrollData() {
        return employeeList;
    }

    public Employee getEmployeePayrollDataById(long employeeId) {
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeId() == employeeId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee not found"));
    }

    public Employee createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        Employee employee = null;
        employee = new Employee(employeeList.size()+1, employeePayrollDTO);
        log.debug("Employee Data: " + employee.toString());
        employeeList.add(employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeePayrollData(long employeeId, EmployeePayrollDTO employeePayrollDTO) {
        Employee employee = this.getEmployeePayrollDataById(employeeId);
        employee.setName(employeePayrollDTO.name);
        employee.setSalary(employeePayrollDTO.salary);
        employeeList.set((int) (employeeId-1), employee);
        return employee;
    }

    public void deleteEmployeePayrollData(long employeeId) {
        employeeList.removeIf(employee -> employee.getEmployeeId() == employeeId);
    }
}