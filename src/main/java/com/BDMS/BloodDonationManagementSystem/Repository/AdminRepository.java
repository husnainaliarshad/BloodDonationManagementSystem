package com.BDMS.BloodDonationManagementSystem.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.BDMS.BloodDonationManagementSystem.Model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByEmail(String email);
}
