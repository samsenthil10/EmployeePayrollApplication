package com.bridgelabz.employeepayrollapplication.model;

import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.employeepayrollapplication.dto.EmployeePayrollDTO;

import lombok.Data;

public @Data class EmployeePayrollData {

    private int employeeId;
    private String name;
    private long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> departments;

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.departments = employeePayrollDTO.departments;
    }
}
