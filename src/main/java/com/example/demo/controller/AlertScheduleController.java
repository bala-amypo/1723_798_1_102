package com.example.demo.controller.schedules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alerts")
public class AlertScheduleController {

    @Autowired
    private AlertScheduleService alertScheduleService;

    // POST /alerts/{warrantyId}
    @PostMapping("/{warrantyId}")
    public AlertSchedule createSchedule(
            @PathVariable Long warrantyId,
            @RequestBody AlertSchedule schedule) {

        return alertScheduleService.createSchedule(warrantyId, schedule);
    }

    // GET /alerts/warranty/{warrantyId}
    @GetMapping("/warranty/{warrantyId}")
    public List<AlertSchedule> getSchedules(
            @PathVariable Long warrantyId) {

        return alertScheduleService.getSchedules(warrantyId);
    }

    // PUT /alerts/{alertId}/toggle
    @PutMapping("/{alertId}/toggle")
    public AlertSchedule toggleSchedule(
            @PathVariable Long alertId) {

        return alertScheduleService.toggleSchedule(alertId);
    }
}
