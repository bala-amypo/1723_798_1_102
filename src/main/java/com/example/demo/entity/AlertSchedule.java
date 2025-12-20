package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AlertSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Warranty warranty;
    private Integer daysBeforeExpiry;
    private Boolean enabled;
    
    // Constructors
    public AlertSchedule() {
    }
    
    public AlertSchedule(Long id, Warranty warranty, Integer daysBeforeExpiry, Boolean enabled) {
        this.id = id;
        this.warranty = warranty;
        this.daysBeforeExpiry = daysBeforeExpiry;
        this.enabled = enabled;
    }
    
    // Builder method for tests
    public static AlertScheduleBuilder builder() {
        return new AlertScheduleBuilder();
    }
    
    // Static builder class
    public static class AlertScheduleBuilder {
        private Long id;
        private Warranty warranty;
        private Integer daysBeforeExpiry;
        private Boolean enabled;
        
        public AlertScheduleBuilder id(Long id) {
            this.id = id;
            return this;
        }
        
        public AlertScheduleBuilder warranty(Warranty warranty) {
            this.warranty = warranty;
            return this;
        }
        
        public AlertScheduleBuilder daysBeforeExpiry(Integer daysBeforeExpiry) {
            this.daysBeforeExpiry = daysBeforeExpiry;
            return this;
        }
        
        public AlertScheduleBuilder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }
        
        public AlertSchedule build() {
            return new AlertSchedule(id, warranty, daysBeforeExpiry, enabled);
        }
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Warranty getWarranty() {
        return warranty;
    }
    
    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }
    
    public Integer getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }
    
    public void setDaysBeforeExpiry(Integer daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }
    
    public Boolean getEnabled() {
        return enabled;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}