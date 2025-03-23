package com.BDMS.BloodDonationManagementSystem.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "hospitals")
public class Hospital extends User {
    private String hospitalName;
    private String location;
    private String contactNumber;
}

