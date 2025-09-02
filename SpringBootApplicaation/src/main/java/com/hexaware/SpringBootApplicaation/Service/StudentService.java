package com.hexaware.SpringBootApplicaation.Service;

import com.hexaware.SpringBootApplicaation.Entity.Student;

import java.util.List;

public interface StudentService {

    Student createUser(Student stud);

    List<Student> getAllStudents();

   Student getStudentById(int studId);

    boolean deleteStudentById(int studId);

    Student updateStudentById(int studId, Student stud);

    //to get a info from table by using an id, we need 2 methods . One is findbyid and get

}
