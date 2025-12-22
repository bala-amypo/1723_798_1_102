// package com.example.demo.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Product {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     private String brand;

//     @Column(nullable = false)
//     private String modelNumber;

//     @Column(nullable = false)
//     private String category;
    
  
//     public Product() {
//     }
    
//     public Product(Long id, String name, String brand, String modelNumber, String category) {
//         this.id = id;
//         this.name = name;
//         this.brand = brand;
//         this.modelNumber = modelNumber;
//         this.category = category;
//     }
    
   
//     public static ProductBuilder builder() {
//         return new ProductBuilder();
//     }
    
   
//     public static class ProductBuilder {
//         private Long id;
//         private String name;
//         private String brand;
//         private String modelNumber;
//         private String category;
        
//         public ProductBuilder id(Long id) {
//             this.id = id;
//             return this;
//         }
        
//         public ProductBuilder name(String name) {
//             this.name = name;
//             return this;
//         }
        
//         public ProductBuilder brand(String brand) {
//             this.brand = brand;
//             return this;
//         }
        
//         public ProductBuilder modelNumber(String modelNumber) {
//             this.modelNumber = modelNumber;
//             return this;
//         }
        
//         public ProductBuilder category(String category) {
//             this.category = category;
//             return this;
//         }
        
//         public Product build() {
//             return new Product(id, name, brand, modelNumber, category);
//         }
//     }
    
  
//     public Long getId() {
//         return id;
//     }
    
//     public void setId(Long id) {
//         this.id = id;
//     }
    
//     public String getName() {
//         return name;
//     }
    
//     public void setName(String name) {
//         this.name = name;
//     }
    
//     public String getBrand() {
//         return brand;
//     }
    
//     public void setBrand(String brand) {
//         this.brand = brand;
//     }
    
//     public String getModelNumber() {
//         return modelNumber;
//     }
    
//     public void setModelNumber(String modelNumber) {
//         this.modelNumber = modelNumber;
//     }
    
//     public String getCategory() {
//         return category;
//     }
    
//     public void setCategory(String category) {
//         this.category = category;
//     }
// }