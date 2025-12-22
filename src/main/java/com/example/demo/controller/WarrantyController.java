// package com.example.demo.controller.warranties;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.Warranty;
// import com.example.demo.service.WarrantyService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;

// @CrossOrigin(origins = "*")
// @RestController
// @RequestMapping("/warranties")
// @Tag(name = "Warranties", description = "Warranty management endpoints")
// public class WarrantyController {

//     private final WarrantyService warrantyService;
    
//     public WarrantyController(WarrantyService warrantyService) {
//         this.warrantyService = warrantyService;
//     }

//     @PostMapping("/register/{userId}/{productId}")
//     @Operation(summary = "Register a warranty")
//     public Warranty registerWarranty(
//             @PathVariable Long userId,
//             @PathVariable Long productId,
//             @RequestBody Warranty warranty) {

//         return warrantyService.registerWarranty(userId, productId, warranty);
//     }

//     @GetMapping("/{warrantyId}")
//     @Operation(summary = "Get warranty by ID")
//     public Warranty getWarranty(
//             @PathVariable Long warrantyId) {

//         return warrantyService.getWarranty(warrantyId);
//     }

//     @GetMapping("/user/{userId}")
//     @Operation(summary = "Get all warranties for a user")
//     public List<Warranty> getUserWarranties(
//             @PathVariable Long userId) {

//         return warrantyService.getUserWarranties(userId);
//     }
// }