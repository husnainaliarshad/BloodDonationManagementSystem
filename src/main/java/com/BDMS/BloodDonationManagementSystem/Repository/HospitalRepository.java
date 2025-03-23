package com.BDMS.BloodDonationManagementSystem.Repository;

import com.BDMS.BloodDonationManagementSystem.Model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalRepository extends MongoRepository<Hospital, String> {
    Hospital findByHospitalName(String hospitalName);
}
