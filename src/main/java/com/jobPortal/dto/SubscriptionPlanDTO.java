package com.jobPortal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionPlanDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Integer durationInDays;
    
    // Constructors
    public SubscriptionPlanDTO() {}
    
    public SubscriptionPlanDTO(Long id, String name, String description, Double price, Integer durationInDays) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationInDays = durationInDays;
    }
    
    // Getters and Setters

}