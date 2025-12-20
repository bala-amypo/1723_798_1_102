package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many logs can belong to one warranty
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "warranty_id", nullable = false)
    private Warranty warranty;

    @Column(nullable = false)
    private LocalDateTime sentAt;

    @Column(nullable = false)
    private String message;

    // ---------------- BEFORE USED METHOD ----------------
    // Auto-generate timestamp before saving
    @PrePersist
    private void onCreate() {
        this.sentAt = LocalDateTime.now();
    }

    // ---------------- CONSTRUCTORS ----------------
    // Default constructor (required by JPA)
    public AlertLog() {
    }

    public AlertLog(Long id, Warranty warranty,
                    LocalDateTime sentAt, String message) {
        this.id = id;
        this.warranty = warranty;
        this.sentAt = sentAt;
        this.message = message;
    }

    // ---------------- BUILDER (for tests) ----------------
    public static AlertLogBuilder builder() {
        return new AlertLogBuilder();
    }

    public static class AlertLogBuilder {
        private Long id;
        private Warranty warranty;
        private LocalDateTime sentAt;
        private String message;

        public AlertLogBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AlertLogBuilder warranty(Warranty warranty) {
            this.warranty = warranty;
            return this;
        }

        public AlertLogBuilder sentAt(LocalDateTime sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        public AlertLogBuilder message(String message) {
            this.message = message;
            return this;
        }

        public AlertLog build() {
            return new AlertLog(id, warranty, sentAt, message);
        }
    }

    // ---------------- GETTERS & SETTERS ----------------
    public Long getId() {
        return id;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
