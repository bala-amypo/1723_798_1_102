package com.example.demo.controller.logs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/logs")
public class AlertLogController {

    @Autowired
    private AlertLogService alertLogService;

    // POST /logs/{warrantyId}
    @PostMapping("/{warrantyId}")
    public AlertLog addLog(
            @PathVariable Long warrantyId,
            @RequestBody String message) {

        return alertLogService.addLog(warrantyId, message);
    }

    // GET /logs/{warrantyId}
    @GetMapping("/{warrantyId}")
    public List<AlertLog> getLogs(
            @PathVariable Long warrantyId) {

        return alertLogService.getLogs(warrantyId);
    }
}
