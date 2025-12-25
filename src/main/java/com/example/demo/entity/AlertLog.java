package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_logs")
public class AlertLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warranty_id", nullable = false)
    @JsonIgnore // <-- Prevent lazy loading issues during JSON serialization
    private Warranty warranty;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime sentAt;

    public AlertLog() {}

    public static AlertLogBuilder builder() {
        return new AlertLogBuilder();
    }

    @PrePersist
    public void prePersist() {
        if (sentAt == null) {
            sentAt = LocalDateTime.now();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Warranty getWarranty() { return warranty; }
    public void setWarranty(Warranty warranty) { this.warranty = warranty; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }

    public static class AlertLogBuilder {
        private Long id;
        private Warranty warranty;
        private String message;
        private LocalDateTime sentAt;

        public AlertLogBuilder id(Long id) { this.id = id; return this; }
        public AlertLogBuilder warranty(Warranty warranty) { this.warranty = warranty; return this; }
        public AlertLogBuilder message(String message) { this.message = message; return this; }
        public AlertLogBuilder sentAt(LocalDateTime sentAt) { this.sentAt = sentAt; return this; }

        public AlertLog build() {
            AlertLog log = new AlertLog();
            log.setId(id);
            log.setWarranty(warranty);
            log.setMessage(message);
            log.setSentAt(sentAt);
            return log;
        }
    }
}
