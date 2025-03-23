package com.BDMS.BloodDonationManagementSystem.Controller;

import com.BDMS.BloodDonationManagementSystem.Service.DonorService;
import com.BDMS.BloodDonationManagementSystem.Model.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class DonorController {
    @Autowired
    private DonorService donorService;

    // Get all donors
    @GetMapping
    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    // Get a donor by ID
    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable String id) {
        return donorService.getDonorById(id);
    }

    // Create a new donor
    @PostMapping
    public Donor createDonor(@RequestBody Donor donor) {
        return donorService.createDonor(donor);
    }

    // Update donor details
    @PutMapping("/{id}")
    public Donor updateDonor(@PathVariable String id, @RequestBody Donor updatedDonor) {
        return donorService.updateDonor(id, updatedDonor);
    }

    // Delete a donor
    @DeleteMapping("/{id}")
    public String deleteDonor(@PathVariable String id) {
        donorService.deleteDonor(id);
        return "Donor deleted successfully";
    }

    // Find donor by email
    @GetMapping("/email/{email}")
    public Donor getDonorByEmail(@PathVariable String email) {
        return donorService.getDonorByEmail(email);
    }

    // Check donor eligibility
    @GetMapping("/{id}/eligibility")
    public Boolean checkDonorEligibility(@PathVariable String id) {
        return donorService.checkEligibility(id);
    }

    // Update last donation date
    @PutMapping("/{id}/donation")
    public Donor updateLastDonation(@PathVariable String id, @RequestParam String donationDate) {
        return donorService.updateLastDonationDate(id, donationDate);
    }
}
