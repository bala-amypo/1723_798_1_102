package com.example.demo.controller.warranties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/warranties")
public class WarrantyController {

    @Autowired
    private WarrantyService warrantyService;

    // POST /warranties/register/{userId}/{productId}
    @PostMapping("/register/{userId}/{productId}")
    public Warranty registerWarranty(
            @PathVariable Long userId,
            @PathVariable Long productId,
            @RequestBody Warranty warranty) {

        return warrantyService.registerWarranty(userId, productId, warranty);
    }

    // GET /warranties/{warrantyId}
    @GetMapping("/{warrantyId}")
    public Warranty getWarranty(
            @PathVariable Long warrantyId) {

        return warrantyService.getWarranty(warrantyId);
    }

    // GET /warranties/user/{userId}
    @GetMapping("/user/{userId}")
    public List<Warranty> getUserWarranties(
            @PathVariable Long userId) {

        return warrantyService.getUserWarranties(userId);
    }
}
