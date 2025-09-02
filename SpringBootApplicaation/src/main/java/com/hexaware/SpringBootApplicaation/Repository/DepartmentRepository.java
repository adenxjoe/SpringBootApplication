package com.hexaware.SpringBootApplicaation.Repository;

import com.hexaware.SpringBootApplicaation.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
