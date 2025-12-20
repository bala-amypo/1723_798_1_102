package com.example.demo.controller.logs;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/logs")
@Tag(name = "Alert Logs", description = "Alert log management endpoints")
public class AlertLogController {

    private final AlertLogService alertLogService;
    
    public AlertLogController(AlertLogService alertLogService) {
        this.alertLogService = alertLogService;
    }

    @PostMapping("/{warrantyId}")
    @Operation(summary = "Add a log entry for a warranty")
    public AlertLog addLog(
            @PathVariable Long warrantyId,
            @RequestBody String message) {

        return alertLogService.addLog(warrantyId, message);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "Get all logs for a warranty")
    public List<AlertLog> getLogs(
            @PathVariable Long warrantyId) {

        return alertLogService.getLogs(warrantyId);
    }
}