package com.project.employee.service;

import com.project.employee.dto.DepartmentDto;
import com.project.employee.dto.EmployeeDto;
import com.project.employee.entity.DepartmentEntity;
import com.project.employee.entity.EmployeeEntity;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelToDtoMapper {

    public  EmployeeDto toModel(EmployeeEntity employeeEntity){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName(employeeEntity.getFirstName());
        employeeDto.setLastName(employeeEntity.getLastName());
        employeeDto.setDateOfBirth(employeeEntity.getDateOfBirth());
        employeeDto.setJobTittle(employeeEntity.getJobTittle());
        employeeDto.setGender(employeeEntity.getGender());
        employeeDto.setId(employeeEntity.getId());
        employeeDto.setDepartmentId(employeeEntity.getDepartment().getId());
        return employeeDto;
    }
    public DepartmentDto toModel(DepartmentEntity departmentEntity){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName(departmentEntity.getDepartmentName());
        departmentDto.setId(departmentEntity.getId());
        return departmentDto;
    }

}
