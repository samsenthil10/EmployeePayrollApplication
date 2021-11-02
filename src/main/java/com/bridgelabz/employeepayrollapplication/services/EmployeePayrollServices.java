package com.bridgelabz.employeepayrollapplication.services;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.employeepayrollapplication.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;

import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollServices implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
		return employeePayrollList.get(employeeId);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(employeeId, employeePayrollDTO);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int employeeId) {

	}

}
