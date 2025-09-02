package com.hexaware.SpringBootApplicaation.Controller;

import com.hexaware.SpringBootApplicaation.Entity.Department;
import com.hexaware.SpringBootApplicaation.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.createDept(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int deptId) {
        Department department = departmentService.getDepartmentById(deptId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable("id") int deptId,
            @RequestBody Department department
    ) {
        Department updatedDepartment = departmentService.updateDepartmentById(deptId, department);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") int deptId) {
        boolean isDeleted = departmentService.deleteDepartmentById(deptId);
        if (isDeleted) {
            return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
        }
    }
}
