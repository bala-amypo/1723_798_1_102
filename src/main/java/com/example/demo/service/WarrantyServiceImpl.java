package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WarrantyRepository;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    @Autowired
    private WarrantyRepository warrantyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        warranty.setUser(user);
        warranty.setProduct(product);

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
