package com.jobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobPortal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}