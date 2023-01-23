package com.project.employee.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Data
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    private List<EmployeeEntity> employeeEntityList;

}
