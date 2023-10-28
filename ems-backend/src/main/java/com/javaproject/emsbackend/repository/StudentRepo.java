package com.javaproject.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javaproject.emsbackend.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> { // Change the name to StudentRepo
}
