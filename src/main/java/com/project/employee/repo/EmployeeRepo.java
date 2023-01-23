package com.project.employee.repo;

import com.project.employee.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity,Long> {
        EmployeeEntity findByFirstName(String firstName);
}
