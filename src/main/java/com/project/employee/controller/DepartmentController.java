package com.project.employee.controller;

import com.project.employee.dto.DepartmentDto;
import com.project.employee.entity.DepartmentEntity;
import com.project.employee.exception.DepartmentNullPointerException;
import com.project.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    private DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }
    @GetMapping("/all")
    public List<DepartmentDto> showAll()  {
        return departmentService.showAll();
    }
    @DeleteMapping()
    public String removeByName(@RequestParam String departmentName) throws DepartmentNullPointerException {
       return   departmentService.removeByName(departmentName);
    }
    @GetMapping("/{id}")
    public DepartmentDto showById(@PathVariable Long id) throws DepartmentNullPointerException {
        return departmentService.show(id);
    }
    @PostMapping ("/add")
    public String save(@RequestBody DepartmentEntity department) throws DepartmentNullPointerException {
       return departmentService.add(department);
    }

    @PutMapping ("/update")
    public String update (@RequestBody DepartmentEntity department) throws DepartmentNullPointerException {
        return departmentService.update(department);
    }


}
