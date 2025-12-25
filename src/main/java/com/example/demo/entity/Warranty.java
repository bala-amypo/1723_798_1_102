package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "warranties")
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    public Warranty() {}

    public static WarrantyBuilder builder() {
        return new WarrantyBuilder();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    // Builder
    public static class WarrantyBuilder {
        private Long id;
        private User user;
        private Product product;
        private LocalDate purchaseDate;
        private LocalDate expiryDate;
        private String serialNumber;

        public WarrantyBuilder id(Long id) { this.id = id; return this; }
        public WarrantyBuilder user(User user) { this.user = user; return this; }
        public WarrantyBuilder product(Product product) { this.product = product; return this; }
        public WarrantyBuilder purchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; return this; }
        public WarrantyBuilder expiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; return this; }
        public WarrantyBuilder serialNumber(String serialNumber) { this.serialNumber = serialNumber; return this; }

        public Warranty build() {
            Warranty warranty = new Warranty();
            warranty.setId(id);
            warranty.setUser(user);
            warranty.setProduct(product);
            warranty.setPurchaseDate(purchaseDate);
            warranty.setExpiryDate(expiryDate);
            warranty.setSerialNumber(serialNumber);
            return warranty;
        }
    }
}
