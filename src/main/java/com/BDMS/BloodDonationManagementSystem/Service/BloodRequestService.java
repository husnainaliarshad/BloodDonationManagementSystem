package com.BDMS.BloodDonationManagementSystem.Service;

import com.BDMS.BloodDonationManagementSystem.Model.BloodRequest;
import com.BDMS.BloodDonationManagementSystem.Model.RequestStatus;
import com.BDMS.BloodDonationManagementSystem.Repository.BloodRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BloodRequestService {
    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    public List<BloodRequest> getAllBloodRequests() {
        return bloodRequestRepository.findAll();
    }

    public Optional<BloodRequest> getBloodRequestById(String id) {
        return bloodRequestRepository.findById(id);
    }

    public List<BloodRequest> getRequestsByHospital(String hospitalId) {
        return bloodRequestRepository.findByHospitalId(hospitalId);
    }

    public List<BloodRequest> getRequestsByStatus(RequestStatus status) {
        return bloodRequestRepository.findByStatus(status);
    }

    public BloodRequest createBloodRequest(BloodRequest request) {
        request.setStatus(RequestStatus.PENDING); // Default status
        return bloodRequestRepository.save(request);
    }

    public BloodRequest updateBloodRequestStatus(String id, RequestStatus status) {
        Optional<BloodRequest> requestOpt = bloodRequestRepository.findById(id);
        if (requestOpt.isPresent()) {
            BloodRequest request = requestOpt.get();
            request.setStatus(status);
            return bloodRequestRepository.save(request);
        }
        return null;
    }

    public void deleteBloodRequest(String id) {
        bloodRequestRepository.deleteById(id);
    }
}
