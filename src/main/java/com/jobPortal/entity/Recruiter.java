package com.jobPortal.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jobPortal.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recruiters")
@Getter
@Setter
public class Recruiter extends User {
    private String companyName;
    private String companyAddress;
    private String phone;
    private String website;
    
    // Constructors
    public Recruiter() {
        super();
    }
    
    public Recruiter(String email, String password, String companyName) {
        super(email, password, UserRole.RECRUITER);
        this.companyName = companyName;
    }
    
    // Getters and Setters
   
}