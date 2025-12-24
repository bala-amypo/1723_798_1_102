package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "alert_schedules")
public class AlertSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warranty_id", nullable = false)
    private Warranty warranty;
    
    @Column(nullable = false)
    private Integer daysBeforeExpiry;
    
    @Column(nullable = false)
    private Boolean enabled = true;
    
    public AlertSchedule() {}
    
    public static AlertScheduleBuilder builder() {
        return new AlertScheduleBuilder();
    }  
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Warranty getWarranty() { return warranty; }
    public void setWarranty(Warranty warranty) { this.warranty = warranty; }
    public Integer getDaysBeforeExpiry() { return daysBeforeExpiry; }
    public void setDaysBeforeExpiry(Integer daysBeforeExpiry) { this.daysBeforeExpiry = daysBeforeExpiry; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    
    public static class AlertScheduleBuilder {
        private Long id;
        private Warranty warranty;
        private Integer daysBeforeExpiry;
        private Boolean enabled = true;
        
        public AlertScheduleBuilder id(Long id) { this.id = id; return this; }
        public AlertScheduleBuilder warranty(Warranty warranty) { this.warranty = warranty; return this; }
        public AlertScheduleBuilder daysBeforeExpiry(Integer daysBeforeExpiry) { this.daysBeforeExpiry = daysBeforeExpiry; return this; }
        public AlertScheduleBuilder enabled(Boolean enabled) { this.enabled = enabled; return this; }
        
        public AlertSchedule build() {
            AlertSchedule schedule = new AlertSchedule();
            schedule.setId(id);
            schedule.setWarranty(warranty);
            schedule.setDaysBeforeExpiry(daysBeforeExpiry);
            schedule.setEnabled(enabled);
            return schedule;
        }
    }
}