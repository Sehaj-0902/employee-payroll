package com.bridgelabz.employee_payroll.repository;

import com.bridgelabz.employee_payroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository <Employee, Long> {
    @Query(value = "select * from employee_payroll, employee_department where employee_id = id and department = :department", nativeQuery = true)
    List<Employee> findEmployeesByDepartment(String department);
}
