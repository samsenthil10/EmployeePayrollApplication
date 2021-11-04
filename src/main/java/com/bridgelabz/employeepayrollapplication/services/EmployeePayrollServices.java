package com.bridgelabz.employeepayrollapplication.services;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.employeepayrollapplication.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;

import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollServices implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
	private int counter = 1;

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {

		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {

		return employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == employeeId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee not found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {

		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(counter++, employeePayrollDTO);
		employeePayrollList.add(employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {

		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
		employeePayrollData.setName(employeePayrollDTO.name);
		employeePayrollData.setSalary(employeePayrollDTO.salary);
		employeePayrollList.set(employeeId - 1, employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int employeeId) {

		employeePayrollList.remove(employeeId - 1);
		counter--;
	}
}
