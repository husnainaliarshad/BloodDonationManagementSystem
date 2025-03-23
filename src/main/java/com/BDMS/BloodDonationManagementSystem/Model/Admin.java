package com.BDMS.BloodDonationManagementSystem.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "admins")
public class Admin extends User {
    private String adminCode; // Optional for additional security
}
