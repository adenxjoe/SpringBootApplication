package com.hexaware.SpringBootApplicaation.Entity;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String studentName;
    private int age;

    @ManyToOne
    private Department department; // auto wired

    //param constructor
    public Student(int id, String studentName, int age) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    //def constructor
    public Student() {
    }

    //getters and setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
