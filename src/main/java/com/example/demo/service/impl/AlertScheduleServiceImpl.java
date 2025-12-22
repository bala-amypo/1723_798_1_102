// package com.example.demo.service;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.AlertSchedule;
// import com.example.demo.entity.Warranty;
// import com.example.demo.repository.AlertScheduleRepository;
// import com.example.demo.repository.WarrantyRepository;

// @Service
// public class AlertScheduleServiceImpl implements AlertScheduleService {

//     private final AlertScheduleRepository alertScheduleRepository;
//     private final WarrantyRepository warrantyRepository;
    
//     public AlertScheduleServiceImpl(AlertScheduleRepository alertScheduleRepository,
//                                    WarrantyRepository warrantyRepository) {
//         this.alertScheduleRepository = alertScheduleRepository;
//         this.warrantyRepository = warrantyRepository;
//     }

//     @Override
//     public AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule) {

//         Warranty warranty = warrantyRepository.findById(warrantyId)
//                 .orElseThrow(() -> new RuntimeException("Warranty not found"));

//         if (schedule.getDaysBeforeExpiry() < 0) {
//             throw new RuntimeException("daysBeforeExpiry must be >= 0");
//         }

//         schedule.setWarranty(warranty);

//         if (schedule.getEnabled() == null) {
//             schedule.setEnabled(true);
//         }

//         return alertScheduleRepository.save(schedule);
//     }

//     @Override
//     public List<AlertSchedule> getSchedules(Long warrantyId) {
//         return alertScheduleRepository.findByWarrantyId(warrantyId);
//     }

//     @Override
//     public AlertSchedule toggleSchedule(Long alertId) {
//         AlertSchedule alert = alertScheduleRepository.findById(alertId)
//                 .orElseThrow(() -> new RuntimeException("Alert not found"));

//         alert.setEnabled(!alert.getEnabled());
//         return alertScheduleRepository.save(alert);
//     }
// }