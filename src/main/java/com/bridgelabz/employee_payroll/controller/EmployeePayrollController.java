package com.bridgelabz.employee_payroll.controller;

import com.bridgelabz.employee_payroll.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get Call Successful", HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("employeeId") long employeeId) {
        return new ResponseEntity<String>("Get Call Successful for ID: " + employeeId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody Employee employee) {
        return new ResponseEntity<String>("Created Employee Payroll Data for: " + employee, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody Employee employee) {
        return new ResponseEntity<String>("Updated Employee Payroll Data for: " + employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("employeeId") long employeeId) {
        return new ResponseEntity<String>("Delete Call Successful for ID: " + employeeId, HttpStatus.OK);
    }
}