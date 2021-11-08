package com.bridgelabz.employeepayrollapplication.services;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.employeepayrollapplication.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapplication.repository.EmployeePayrollRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollServices implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRepository employeeRepository;

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {

		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {

		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeePayrollException("Employee with id " + employeeId + " does not exist..!"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {

		EmployeePayrollData employeePayrollData= new EmployeePayrollData(employeePayrollDTO);
		log.debug("Employee Payroll Data: " + employeePayrollData.toString());
		return employeeRepository.save(employeePayrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
		
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
		employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);
		return employeeRepository.save(employeePayrollData);
	}

	@Override
	public void deleteEmployeePayrollData(int employeeId) {

		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
		employeeRepository.delete(employeePayrollData);
	}

	@Override
	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeeRepository.findEmployeeByDepartment(department);
	}
}
