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
    
    public AlertSchedule() {
    }


    public AlertSchedule(Long id, Warranty warranty, Integer daysBeforeExpiry, Boolean enabled) {
        this.id = id;
        this.warranty = warranty;
        this.daysBeforeExpiry = daysBeforeExpiry;
        this.enabled = enabled;
    }


}
