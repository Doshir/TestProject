package com.project.employee.controller;

import com.project.employee.dto.EmployeeDto;
import com.project.employee.entity.EmployeeEntity;
import com.project.employee.exception.EmployeeNullPointerException;
import com.project.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
        @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody EmployeeEntity employee) throws Exception {
        try {
            employeeService.add(employee);
           return ResponseEntity.ok("Employee saved");
        }
        catch (Exception e){
           return ResponseEntity.badRequest().body("Mistake");
        }
    }
    @GetMapping("/{id}")
    public EmployeeDto get(@PathVariable Long id) throws EmployeeNullPointerException {
             return  employeeService.show(id);
    }
    @GetMapping("/all")
    public List<EmployeeDto> getAll(){
            return employeeService.showAll();
    }
    @PutMapping
    public EmployeeDto update(@RequestBody EmployeeEntity employee) throws EmployeeNullPointerException {
            return employeeService.update(employee);
    }
    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id ) throws EmployeeNullPointerException {
            employeeService.remove(id);
    }
    @GetMapping("/find")
    public EmployeeDto findFirstName(@RequestParam String name) throws EmployeeNullPointerException {
          return  employeeService.findFirstName(name);

    }

}
