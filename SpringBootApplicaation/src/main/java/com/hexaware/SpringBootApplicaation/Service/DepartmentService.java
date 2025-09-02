package com.hexaware.SpringBootApplicaation.Service;

import com.hexaware.SpringBootApplicaation.Entity.Department;

import java.util.List;

public interface DepartmentService {

    Department createDept(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(int deptId);

    boolean deleteDepartmentById(int deptId);

    Department updateDepartmentById(int deptId, Department department);
}
