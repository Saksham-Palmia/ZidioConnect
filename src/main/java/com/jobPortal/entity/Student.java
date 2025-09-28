package com.jobPortal.entity;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jobPortal.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student extends User {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String resumeUrl;
    
    @ElementCollection
    private List<String> skills;
    
    // Constructors
    public Student() {
        super();
    }
    
    public Student(String email, String password, String firstName, String lastName) {
        super(email, password, UserRole.STUDENT);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // Getters and Setters
   
}