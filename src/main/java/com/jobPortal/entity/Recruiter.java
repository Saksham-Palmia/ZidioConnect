package com.jobPortal.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jobPortal.enums.UserRole;

@Entity
@Table(name = "recruiters")
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
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public String getCompanyAddress() { return companyAddress; }
    public void setCompanyAddress(String companyAddress) { this.companyAddress = companyAddress; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
}