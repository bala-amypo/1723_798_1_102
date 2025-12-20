package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many alerts can belong to one warranty
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "warranty_id", nullable = false)
    private Warranty warranty;

    @Column(nullable = false)
    private Integer daysBeforeExpiry;

    @Column(nullable = false)
    private Boolean enabled;

    // ---------------- VALIDATION ----------------
    @PrePersist
    @PreUpdate
    private void validateDaysBeforeExpiry() {
        if (daysBeforeExpiry == null || daysBeforeExpiry < 0) {
            throw new IllegalArgumentException(
                "daysBeforeExpiry must be greater than or equal to 0"
            );
        }
    }

    // ---------------- CONSTRUCTORS ----------------
    // Default constructor (required by JPA)
    public AlertSchedule() {
    }

    public AlertSchedule(Long id, Warranty warranty,
                         Integer daysBeforeExpiry, Boolean enabled) {
        this.id = id;
        this.warranty = warranty;
        this.daysBeforeExpiry = daysBeforeExpiry;
        this.enabled = enabled;
    }

    // ---------------- BUILDER (for tests) ----------------
    public static AlertScheduleBuilder builder() {
        return new AlertScheduleBuilder();
    }

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

    // ---------------- GETTERS & SETTERS ----------------
    public Long getId() {
        return id;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public Integer getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public void setDaysBeforeExpiry(Integer daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
