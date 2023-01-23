package com.project.employee.entity;

import com.project.employee.dto.EmployeeDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;
    private String jobTittle;
    private String gender;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;
}
