package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WarrantyRepository;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    
    public WarrantyServiceImpl(WarrantyRepository warrantyRepository,
                              UserRepository userRepository,
                              ProductRepository productRepository) {
        this.warrantyRepository = warrantyRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {

        // Check if serial number is unique
        if (warrantyRepository.existsBySerialNumber(warranty.getSerialNumber())) {
            throw new RuntimeException("Serial number must be unique");
        }

        // Fetch user and product
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Business rule: expiry date must be after purchase date
        if (warranty.getExpiryDate().isBefore(warranty.getPurchaseDate())) {
            throw new RuntimeException("Expiry date must be after purchase date");
        }

        // Set associations
        warranty.setUser(user);
        warranty.setProduct(product);

        // Save warranty
        return warrantyRepository.save(warranty);
    }

    @Override
    public Warranty getWarranty(Long warrantyId) {
        return warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepository.findByUserId(userId);
    }
}