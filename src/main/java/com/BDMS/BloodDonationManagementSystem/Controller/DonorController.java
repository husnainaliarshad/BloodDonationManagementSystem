package com.BDMS.BloodDonationManagementSystem.Controller;

import com.BDMS.BloodDonationManagementSystem.Service.DonorService;
import com.BDMS.BloodDonationManagementSystem.Model.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.plaf.TreeUI;

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
        
        Donor get = donorService.getDonorById(id);
       
        return get;
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

    @GetMapping("/email/{email}")
public ResponseEntity<Donor> getDonorByEmail(@PathVariable String email) {
    Donor donor = donorService.getDonorByEmail(email);

    if (donor == null) {
        return ResponseEntity.notFound().build(); // ✅ Returns 404 if donor not found
    }

    return ResponseEntity.ok(donor); // ✅ Returns 200 OK with donor details
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

    @GetMapping("/me")
    public ResponseEntity<?> getDonorProfile(@RequestParam String email) {
        Donor donor = donorService.getDonorByEmail(email);
        if (donor == null) {
            return ResponseEntity.status(404).body(Map.of("message", "User not found"));
        }
    
        // ✅ Ensure no `null` values (Replace `null` with `"N/A"`)
        String lastDonationDate = (donor.getLastDonationDate() != null) ? donor.getLastDonationDate() : "N/A";
    
        return ResponseEntity.ok(Map.of(
            "name", donor.getName(),
            "email", donor.getEmail(),
            "bloodType", donor.getBloodType(),
            "lastDonationDate", lastDonationDate // ✅ No more `null`
        ));
    }
    


}
