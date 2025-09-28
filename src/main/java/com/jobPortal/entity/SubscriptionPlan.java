package com.jobPortal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subscription_plans")
@Getter
@Setter
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Double price;
    private String description;
    private Integer durationInDays;
    
    // Constructors
    public SubscriptionPlan() {}
    
    public SubscriptionPlan(String name, String description, Double price, Integer durationInDays) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationInDays = durationInDays;
    }
    
    // Getters and Setters
   
}