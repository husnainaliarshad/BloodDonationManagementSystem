package com.BDMS.BloodDonationManagementSystem;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "donors")
public class Donor extends User {
    private String bloodType;
    private String lastDonationDate;
    private Boolean isEligible;
}
