package com.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.dto.StudentDTO;
import com.jobPortal.entity.Student;
import com.jobPortal.repository.StudentRepository;
import com.jobPortal.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Override
    public Student updateStudentProfile(Long id, StudentDTO studentDTO) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (!studentOptional.isPresent()) {
            throw new RuntimeException("Student not found");
        }
        
        Student student = studentOptional.get();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPhone(studentDTO.getPhone());
        student.setAddress(studentDTO.getAddress());
        student.setResumeUrl(studentDTO.getResumeUrl());
        student.setSkills(studentDTO.getSkills());
        
        return studentRepository.save(student);
    }
    
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));
    }
    
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}