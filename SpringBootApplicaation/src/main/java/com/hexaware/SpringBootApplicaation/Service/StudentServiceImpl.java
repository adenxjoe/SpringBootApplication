package com.hexaware.SpringBootApplicaation.Service;

import com.hexaware.SpringBootApplicaation.Entity.Department;
import com.hexaware.SpringBootApplicaation.Entity.Student;
import com.hexaware.SpringBootApplicaation.Repository.DepartmentRepository;
import com.hexaware.SpringBootApplicaation.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepo;
    private DepartmentRepository departmentRepository;

    public StudentServiceImpl(StudentRepository studentRepo, DepartmentRepository departmentRepository) {
        this.studentRepo = studentRepo;
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Student createUser(Student stud) {

        int deptId = stud.getDepartment().getDeptId();

        //  Fetch full department from DB
        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + deptId));

        stud.setDepartment(dept);

        return (Student) studentRepo.save(stud);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(int studId) {
        Optional<Student> studentId = studentRepo.findById((long) studId);
        return studentId.get();
    }

    @Override
    public boolean deleteStudentById(int studId) {
        Optional<Student> student = studentRepo.findById((long) studId);
        if (student.isPresent()) {
            studentRepo.deleteById((long) studId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student updateStudentById(int studId, Student stud) {
        // TODO Auto-generated method stub
        Optional<Student> oldStudentOptional = studentRepo.findById((long) studId);

        if(oldStudentOptional.isPresent()) {
            Student oldStudent = oldStudentOptional.get();

            oldStudent.setStudentName(stud.getStudentName());
            oldStudent.setAge(stud.getAge());
            oldStudent.setDepartment(stud.getDepartment());

            return studentRepo.save(oldStudent);
        }else {
            throw new RuntimeException("Student with id: "+studId+" is not found");
        }
    }



    //to get a info from table by using an id, we need 2 methods . One is findbyid and get



}
