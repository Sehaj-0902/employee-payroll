package com.bridgelabz.employee_payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {
    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;

    @Min(value = 500, message = "Minimum Wage should be more than 500")
    public int salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start date should not be empty")
    @PastOrPresent(message = "Start date should be past or today's date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty")
    public String note;

    @NotBlank(message = "Profile picture cannot be Empty")
    public String profilePic;

    @NotNull(message = "Department should not be Empty")
    public List<String> department;
}