package com.javaproject.emsbackend.service;

import com.javaproject.emsbackend.exception.ResourceNotFoundException;
import com.javaproject.emsbackend.model.Student;
import com.javaproject.emsbackend.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudentById(Integer id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));
    }

    public Student updateStudent(Integer id, Student studentDetails) {
        Student student = getStudentById(id);

        // Update student details
        student.setName(studentDetails.getName());
        student.setDepartment(studentDetails.getDepartment());
        student.setPhoneNumber(studentDetails.getPhoneNumber());

        return studentRepo.save(student);
    }

    public void deleteStudent(Integer id) {
        Student student = getStudentById(id);
        studentRepo.delete(student);
    }
}
