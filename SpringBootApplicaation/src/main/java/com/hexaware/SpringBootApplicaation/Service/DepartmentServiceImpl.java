package com.hexaware.SpringBootApplicaation.Service;

import com.hexaware.SpringBootApplicaation.Entity.Department;
import com.hexaware.SpringBootApplicaation.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDept(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new RuntimeException("Department not found with ID: " + deptId);
        }
    }

    @Override
    public boolean deleteDepartmentById(int deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        if (department.isPresent()) {
            departmentRepository.deleteById(deptId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Department updateDepartmentById(int deptId, Department department) {
        Optional<Department> existingDepartmentOptional = departmentRepository.findById(deptId);
        if (existingDepartmentOptional.isPresent()) {
            Department existingDepartment = existingDepartmentOptional.get();

            existingDepartment.setDeptName(department.getDeptName());

            return departmentRepository.save(existingDepartment);
        } else {
            throw new RuntimeException("Department with ID: " + deptId + " not found");
        }
    }
}
