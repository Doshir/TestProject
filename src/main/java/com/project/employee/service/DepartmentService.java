package com.project.employee.service;

import com.project.employee.dto.DepartmentDto;
import com.project.employee.entity.DepartmentEntity;
import com.project.employee.exception.DepartmentNullPointerException;
import com.project.employee.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private DepartmentRepo departmentRepo;
    private ModelToDtoMapper modelToDtoMapper;

    @Autowired
   public DepartmentService(DepartmentRepo departmentRepo, ModelToDtoMapper modelToDtoMapper){
       this.departmentRepo= departmentRepo;
       this.modelToDtoMapper=modelToDtoMapper;
   }


    public String remove(Long id) throws DepartmentNullPointerException {
        if(departmentRepo.findById(id).isEmpty()){
            throw new DepartmentNullPointerException("Department is null");
        }
        else {
            departmentRepo.deleteById(id);

        }
        return "Department deleted";
    }
    public List<DepartmentDto> showAll()  {
        List<DepartmentDto> list = new ArrayList<>();
        List<DepartmentEntity> departmentEntityList = (List<DepartmentEntity>) departmentRepo.findAll();
        for (int i = 0; i<departmentEntityList.size();i++){
            list.add(modelToDtoMapper.toModel(departmentEntityList.get(i)));
        }

        return list;
    }
    public DepartmentDto show(Long id) throws DepartmentNullPointerException {
        if(departmentRepo.findById(id).isEmpty()){
            throw new DepartmentNullPointerException("Department is null");
        }
        else {
           DepartmentEntity department = departmentRepo.findById(id).orElseThrow(()->new IllegalStateException("Mistake"));

         return modelToDtoMapper.toModel(department);
        }

    }
    public String removeByName(String name) throws DepartmentNullPointerException {
        if(departmentRepo.deleteByDepartmentName(name)==null){
            throw new DepartmentNullPointerException("Department not exist");
        }
        else {
            departmentRepo.deleteByDepartmentName(name);
            return "Department deleted";
        }
    }
    public String add(DepartmentEntity department) throws DepartmentNullPointerException {
        if(department==null){
            throw new DepartmentNullPointerException("Department is null");
        }
        else {
            departmentRepo.save(department);
            return "Department Saved";
        }


    }

    public String update(DepartmentEntity department) throws DepartmentNullPointerException {
       if(departmentRepo.findById(department.getId()).isEmpty()){
           throw new DepartmentNullPointerException("Department is null");
       }
       DepartmentEntity departmentUpdate = departmentRepo.findById(department.getId()).orElseThrow(()->new IllegalStateException("Mistake"));
       departmentUpdate.setDepartmentName(department.getDepartmentName());
        departmentRepo.save(departmentUpdate);
        return "Department saved";
    }





}
