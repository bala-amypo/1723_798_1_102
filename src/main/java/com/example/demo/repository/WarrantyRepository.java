package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Warranty;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    List<Warranty> findByUserId(Long userId);

    boolean existsBySerialNumber(String serialNumber);
}
