package com.BDMS.BloodDonationManagementSystem.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "donations")
public class Donation {
    @Id
    private String id;

    private String donorId; // References Donor
    private String bloodBankId; // References BloodBank
    private String donationDate;
    private String bloodType;
    private int quantity;
}
