package com.BDMS.BloodDonationManagementSystem.Repository;

import com.BDMS.BloodDonationManagementSystem.Model.BloodRequest;
import com.BDMS.BloodDonationManagementSystem.Model.RequestStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BloodRequestRepository extends MongoRepository<BloodRequest, String> {
    List<BloodRequest> findByHospitalId(String hospitalId);
    List<BloodRequest> findByStatus(RequestStatus status);
}
