package com.project.employee.service;

import com.project.employee.dto.EmployeeDto;
import com.project.employee.entity.EmployeeEntity;
import com.project.employee.exception.EmployeeNullPointerException;
import com.project.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelToDtoMapper modelToDtoMapper;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, ModelToDtoMapper modelToDtoMapper) {
        this.employeeRepo = employeeRepo;
        this.modelToDtoMapper = modelToDtoMapper;
    }


    public EmployeeEntity add(EmployeeEntity employee) throws EmployeeNullPointerException {
        if (employee == null) {
            throw new EmployeeNullPointerException("Employee is null");
        } else {
            return employeeRepo.save(employee);
        }


    }

    public EmployeeDto show(Long id) throws EmployeeNullPointerException {
        if (employeeRepo.findById(id).isEmpty()) {
            throw new EmployeeNullPointerException("Employee is null");
        } else {
            EmployeeEntity employee = employeeRepo.findById(id).orElseThrow(()->new IllegalStateException("Mistake"));

            return modelToDtoMapper.toModel(employee);
        }
    }

    public List<EmployeeDto> showAll() {

        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        List<EmployeeEntity> employeeEntities = (List<EmployeeEntity>) employeeRepo.findAll();

        for(int i = 0; i<employeeEntities.size();i++){
            employeeDtoList.add( modelToDtoMapper.toModel(employeeEntities.get(i)));
        }
        return employeeDtoList;
    }

    public String remove(Long id) throws EmployeeNullPointerException {
        if (employeeRepo.findById(id).isEmpty()) {
            throw new EmployeeNullPointerException("Employee is null with id");
        } else {
            employeeRepo.deleteById(id);
            return "User deleted";
        }
    }

    public EmployeeDto update(EmployeeEntity employee) throws EmployeeNullPointerException {
        if (employeeRepo.findById(employee.getId()).isEmpty()) {
            throw new EmployeeNullPointerException("Employee is null with id");
        }
        EmployeeEntity employee1 = employeeRepo.findById(employee.getId()).orElseThrow(()->new IllegalStateException("Mistake"));
        employee1.setDateOfBirth(employee.getDateOfBirth());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setGender(employee.getGender());
        employee1.setJobTittle(employee.getJobTittle());
        employee1.setDepartment(employee1.getDepartment());
       EmployeeEntity employee2 = employeeRepo.save(employee1);
        return modelToDtoMapper.toModel(employee2);
    }

    public EmployeeDto findFirstName (String firstName) throws EmployeeNullPointerException {
        if(firstName==null){
            throw  new EmployeeNullPointerException("Name is null");
        }
       EmployeeEntity employeeEntity = employeeRepo.findByFirstName(firstName);

        return modelToDtoMapper.toModel(employeeEntity);

    }


    public ModelToDtoMapper getModelToDtoMapper() {
        return modelToDtoMapper;
    }
}
