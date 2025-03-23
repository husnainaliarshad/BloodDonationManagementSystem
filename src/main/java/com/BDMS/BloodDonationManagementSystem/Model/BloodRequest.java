package com.BDMS.BloodDonationManagementSystem.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "blood_requests")


public class BloodRequest {
    @Id
    private String id;

    private String hospitalId; // References Hospital making the request
    private String bloodType;
    private int quantity;
    private boolean isEmergency;
    private RequestStatus status; // PENDING, APPROVED, REJECTED, FULFILLED
}
