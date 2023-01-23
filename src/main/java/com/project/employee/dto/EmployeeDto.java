package com.project.employee.dto;

import com.project.employee.entity.DepartmentEntity;
import com.project.employee.entity.EmployeeEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDto {
    private Long Id;
    private String firstName;
    private String lastName;
    private String jobTittle;
    private String gender;
    private LocalDate dateOfBirth;
    private Long departmentId;



}
