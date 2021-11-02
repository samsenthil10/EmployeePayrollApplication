package com.bridgelabz.employeepayrollapplication.services;

import java.util.List;

import com.bridgelabz.employeepayrollapplication.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(int employeeId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO);

	void deleteEmployeePayrollData(int employeeId);
}
