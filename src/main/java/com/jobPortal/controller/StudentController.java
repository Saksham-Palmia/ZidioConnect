package com.jobPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.dto.StudentDTO;
import com.jobPortal.entity.Student;
import com.jobPortal.repository.security.CustomUserDetails;
import com.jobPortal.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @GetMapping("/profile")
    public ResponseEntity<Student> getProfile(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Student student = studentService.getStudentById(userDetails.getUser().getId());
        return ResponseEntity.ok(student);
    }
    
    @PutMapping("/profile")
    public ResponseEntity<Student> updateProfile(@RequestBody StudentDTO studentDTO,
                                                @AuthenticationPrincipal CustomUserDetails userDetails) {
        Student student = studentService.updateStudentProfile(userDetails.getUser().getId(), studentDTO);
        return ResponseEntity.ok(student);
    }
    
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }
}