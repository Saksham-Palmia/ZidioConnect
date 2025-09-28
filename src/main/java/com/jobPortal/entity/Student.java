package com.jobPortal.entity;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jobPortal.enums.UserRole;

@Entity
@Table(name = "students")
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
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getResumeUrl() { return resumeUrl; }
    public void setResumeUrl(String resumeUrl) { this.resumeUrl = resumeUrl; }
    
    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }
}