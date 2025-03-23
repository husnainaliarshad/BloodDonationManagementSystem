package com.BDMS.BloodDonationManagementSystem.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;

    private String donorId; // References Donor
    private String message;
    private boolean isRead;
    private LocalDateTime timestamp;

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }
}
