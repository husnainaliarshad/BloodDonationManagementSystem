package com.BDMS.BloodDonationManagementSystem.Repository;

import com.BDMS.BloodDonationManagementSystem.Model.BloodBank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BloodBankRepository extends MongoRepository<BloodBank, String> {
    BloodBank findByLocation(String location);
}
