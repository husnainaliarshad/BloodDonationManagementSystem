package com.BDMS.BloodDonationManagementSystem.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "blood_banks")
public class BloodBank {
    @Id
    private String id;
    private String name;
    private String location;
    private String contactNumber;
    private int availableUnits; // Total units of blood available
}
