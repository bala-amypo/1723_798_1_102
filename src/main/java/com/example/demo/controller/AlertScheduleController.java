// package com.example.demo.controller.schedules;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.AlertSchedule;
// import com.example.demo.service.AlertScheduleService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;

// @CrossOrigin(origins = "*")
// @RestController
// @RequestMapping("/alerts")
// @Tag(name = "Alert Schedules", description = "Alert schedule management endpoints")
// public class AlertScheduleController {

//     private final AlertScheduleService alertScheduleService;
    
//     public AlertScheduleController(AlertScheduleService alertScheduleService) {
//         this.alertScheduleService = alertScheduleService;
//     }

//     @PostMapping("/{warrantyId}")
//     @Operation(summary = "Create an alert schedule for a warranty")
//     public AlertSchedule createSchedule(
//             @PathVariable Long warrantyId,
//             @RequestBody AlertSchedule schedule) {

//         return alertScheduleService.createSchedule(warrantyId, schedule);
//     }

//     @GetMapping("/warranty/{warrantyId}")
//     @Operation(summary = "Get all schedules for a warranty")
//     public List<AlertSchedule> getSchedules(
//             @PathVariable Long warrantyId) {

//         return alertScheduleService.getSchedules(warrantyId);
//     }

//     @PutMapping("/{alertId}/toggle")
//     @Operation(summary = "Toggle an alert schedule")
//     public AlertSchedule toggleSchedule(
//             @PathVariable Long alertId) {

//         return alertScheduleService.toggleSchedule(alertId);
//     }
// }