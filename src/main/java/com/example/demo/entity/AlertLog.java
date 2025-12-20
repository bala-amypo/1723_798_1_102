package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class AlertLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Warranty warranty;
        
    private LocalDateTime sentAt;
    private String message;
    
    // Constructors
    public AlertLog() {
    }
    
    public AlertLog(Long id, Warranty warranty, LocalDateTime sentAt, String message) {
        this.id = id;
        this.warranty = warranty;
        this.sentAt = sentAt;
        this.message = message;
    }
    
    // Builder method for tests
    public static AlertLogBuilder builder() {
        return new AlertLogBuilder();
    }
    
    // Static builder class
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
    
    @PrePersist
    public void onCreate() {
        this.sentAt = LocalDateTime.now();
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
    
    public LocalDateTime getSentAt() {
        return sentAt;
    }
    
    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}