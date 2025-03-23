package com.BDMS.BloodDonationManagementSystem.Repository;


import com.BDMS.BloodDonationManagementSystem.Model.Donor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonorRepository extends MongoRepository<Donor, String> {
    Donor findByEmail(String email); // Custom query to find donor by email
}

