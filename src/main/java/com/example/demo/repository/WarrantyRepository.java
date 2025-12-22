package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Warranty;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
    boolean existsBySerialNumber(String serialNumber);
    
    List<Warranty> findByUserId(Long userId);
    
    @Query("SELECT w FROM Warranty w WHERE w.expiryDate BETWEEN :startDate AND :endDate")
    List<Warranty> findWarrantiesExpiringBetween(
        @Param("startDate") LocalDate startDate, 
        @Param("endDate") LocalDate endDate
    );
}