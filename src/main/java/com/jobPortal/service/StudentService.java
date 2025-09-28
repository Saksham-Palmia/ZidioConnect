package com.jobPortal.service;

import java.util.List;

import com.jobPortal.dto.StudentDTO;
import com.jobPortal.entity.Student;

public interface StudentService {
    Student updateStudentProfile(Long id, StudentDTO studentDTO);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
}