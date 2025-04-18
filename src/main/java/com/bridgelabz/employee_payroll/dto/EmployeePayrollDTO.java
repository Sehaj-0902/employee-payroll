package com.bridgelabz.employee_payroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeePayrollDTO {
    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;

    @Min(value = 500, message = "Minimum Wage should be more than 500")
    public int salary;

    public EmployeePayrollDTO(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{name:" + name + ", salary:" + salary + "}";
    }
}