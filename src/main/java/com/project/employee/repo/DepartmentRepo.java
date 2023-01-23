package com.project.employee.repo;

import com.project.employee.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo extends CrudRepository<DepartmentEntity,Long> {
    DepartmentEntity deleteByDepartmentName(String departmentName);
}
