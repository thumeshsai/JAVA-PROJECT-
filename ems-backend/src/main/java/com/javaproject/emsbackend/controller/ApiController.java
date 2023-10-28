package com.javaproject.emsbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaproject.emsbackend.exception.ResourceNotFoundException; // Import ResourceNotFoundException
import com.javaproject.emsbackend.model.Student;
import com.javaproject.emsbackend.repository.StudentRepo; // Import StudentRepo

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/front/")
public class ApiController {

    @Autowired
    private StudentRepo studentRepo; // Use StudentRepo

    // get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepo.findAll(); // Use studentRepo
    }

    // create student rest api
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.save(student); // Use studentRepo
    }

    // get student by id rest api
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = studentRepo.findById(id) // Use studentRepo
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
        return ResponseEntity.ok(student);
    }

    // update student rest api
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Student student = studentRepo.findById(id) // Use studentRepo
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        // Update student details
        student.setName(studentDetails.getName());
        student.setDepartment(studentDetails.getDepartment());
        student.setPhoneNumber(studentDetails.getPhoneNumber());

        Student updatedStudent = studentRepo.save(student); // Use studentRepo
        return ResponseEntity.ok(updatedStudent);
    }

    // delete student rest api
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Integer id) {
        Student student = studentRepo.findById(id) // Use studentRepo
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        studentRepo.delete(student); // Use studentRepo
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
