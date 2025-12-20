package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private LocalDate purchaseDate;
    private LocalDate expiryDate;

    @Column(unique = true)
    private String serialNumber;
    
    // Constructors
    public Warranty() {
    }
    
    public Warranty(Long id, User user, Product product, LocalDate purchaseDate, 
                   LocalDate expiryDate, String serialNumber) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        this.serialNumber = serialNumber;
    }
    
    // Builder method for tests
    public static WarrantyBuilder builder() {
        return new WarrantyBuilder();
    }
    
    // Static builder class
    public static class WarrantyBuilder {
        private Long id;
        private User user;
        private Product product;
        private LocalDate purchaseDate;
        private LocalDate expiryDate;
        private String serialNumber;
        
        public WarrantyBuilder id(Long id) {
            this.id = id;
            return this;
        }
        
        public WarrantyBuilder user(User user) {
            this.user = user;
            return this;
        }
        
        public WarrantyBuilder product(Product product) {
            this.product = product;
            return this;
        }
        
        public WarrantyBuilder purchaseDate(LocalDate purchaseDate) {
            this.purchaseDate = purchaseDate;
            return this;
        }
        
        public WarrantyBuilder expiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }
        
        public WarrantyBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }
        
        public Warranty build() {
            return new Warranty(id, user, product, purchaseDate, expiryDate, serialNumber);
        }
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public String getSerialNumber() {
        return serialNumber;
    }
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}