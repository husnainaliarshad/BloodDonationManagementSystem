package com.BDMS.BloodDonationManagementSystem.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.BDMS.BloodDonationManagementSystem.Model.Donation;
import java.util.List;

public interface DonationRepository extends MongoRepository<Donation, String> {
    List<Donation> findByDonorId(String donorId);
    List<Donation> findByBloodBankId(String bloodBankId);
}
