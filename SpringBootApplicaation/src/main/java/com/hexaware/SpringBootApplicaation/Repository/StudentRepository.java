package com.hexaware.SpringBootApplicaation.Repository;

import com.hexaware.SpringBootApplicaation.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
