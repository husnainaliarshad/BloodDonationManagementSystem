package com.BDMS.BloodDonationManagementSystem.Controller;

import com.BDMS.BloodDonationManagementSystem.Model.BloodRequest;
import com.BDMS.BloodDonationManagementSystem.Model.RequestStatus;
import com.BDMS.BloodDonationManagementSystem.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bloodrequests")
public class BloodRequestController {
    @Autowired
    private BloodRequestService bloodRequestService;

    @GetMapping
    public List<BloodRequest> getAllBloodRequests() {
        return bloodRequestService.getAllBloodRequests();
    }

    @GetMapping("/{id}")
    public Optional<BloodRequest> getBloodRequestById(@PathVariable String id) {
        return bloodRequestService.getBloodRequestById(id);
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<BloodRequest> getRequestsByHospital(@PathVariable String hospitalId) {
        return bloodRequestService.getRequestsByHospital(hospitalId);
    }

    @GetMapping("/status/{status}")
    public List<BloodRequest> getRequestsByStatus(@PathVariable RequestStatus status) {
        return bloodRequestService.getRequestsByStatus(status);
    }

    @PostMapping
    public BloodRequest createBloodRequest(@RequestBody BloodRequest request) {
        return bloodRequestService.createBloodRequest(request);
    }

    @PutMapping("/{id}/update-status")
    public BloodRequest updateBloodRequestStatus(@PathVariable String id, @RequestParam RequestStatus status) {
        return bloodRequestService.updateBloodRequestStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteBloodRequest(@PathVariable String id) {
        bloodRequestService.deleteBloodRequest(id);
        return "Blood request deleted successfully";
    }
}
