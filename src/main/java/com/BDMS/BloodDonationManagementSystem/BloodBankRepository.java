package com.BDMS.BloodDonationManagementSystem;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface BloodBankRepository extends MongoRepository<BloodBank, String> {
    Optional<BloodBank> findByName(String name); // Find blood bank by name
}
