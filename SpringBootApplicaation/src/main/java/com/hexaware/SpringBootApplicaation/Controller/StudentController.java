package com.hexaware.SpringBootApplicaation.Controller;

import com.hexaware.SpringBootApplicaation.Entity.Student;
import com.hexaware.SpringBootApplicaation.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //to communicate between http request and response - client post man app
    @PostMapping
    public ResponseEntity<Student> CreateUser(@RequestBody Student stud)
    {
        Student savedStudent=studentService.createUser(stud);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> getStudent = studentService.getAllStudents();
        return new ResponseEntity<>(getStudent,HttpStatus.OK);
    }

//    @GetMapping("{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studId){
//        Student getStudentById = studentService.getStudenById(1);
//        return new ResponseEntity<>(getStudentById,HttpStatus.OK);
//    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studId){
        Student getStudentById = studentService.getStudentById(studId);
        return new ResponseEntity<>(getStudentById,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") int studId) {
        boolean isDeleted = studentService.deleteStudentById(studId);
        if (isDeleted) {
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateUser(@PathVariable("id") int studId,@RequestBody Student stud)
    {
        Student updatedStudent=studentService.updateStudentById(studId, stud);
        System.out.println("Hiii");
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);

    }




}
