package com.bridgelabz.employeepayrollapplication.repository;

import java.util.List;

import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

    @Query(value = "select * from employee_payroll,employee_department where employee_id=id and department=:department", nativeQuery = true)
    List<EmployeePayrollData> findEmployeeByDepartment(String department);
}
