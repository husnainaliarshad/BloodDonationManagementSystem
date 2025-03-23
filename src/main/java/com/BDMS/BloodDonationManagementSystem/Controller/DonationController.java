package com.BDMS.BloodDonationManagementSystem.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BDMS.BloodDonationManagementSystem.Model.Donation;
import com.BDMS.BloodDonationManagementSystem.Service.DonationService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donations")
public class DonationController {
    @Autowired
    private DonationService donationService;

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }

    @GetMapping("/{id}")
    public Optional<Donation> getDonationById(@PathVariable String id) {
        return donationService.getDonationById(id);
    }

    @GetMapping("/donor/{donorId}")
    public List<Donation> getDonationsByDonor(@PathVariable String donorId) {
        return donationService.getDonationsByDonor(donorId);
    }

    @GetMapping("/bloodbank/{bloodBankId}")
    public List<Donation> getDonationsByBloodBank(@PathVariable String bloodBankId) {
        return donationService.getDonationsByBloodBank(bloodBankId);
    }

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationService.createDonation(donation);
    }

    @DeleteMapping("/{id}")
    public String deleteDonation(@PathVariable String id) {
        donationService.deleteDonation(id);
        return "Donation record deleted successfully";
    }
}
