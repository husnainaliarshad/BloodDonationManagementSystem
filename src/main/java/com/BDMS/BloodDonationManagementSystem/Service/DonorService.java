package com.BDMS.BloodDonationManagementSystem.Service;

import com.BDMS.BloodDonationManagementSystem.Model.Donor;
import com.BDMS.BloodDonationManagementSystem.Repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;

    // Get all donors
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    // Get donor by ID
    public Donor getDonorById(String id) {
        return donorRepository.findById(id).orElse(null);
    }

    // Create a new donor
    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    // Update donor details
    public Donor updateDonor(String id, Donor updatedDonor) {
        Optional<Donor> existingDonorOpt = donorRepository.findById(id);
        if (existingDonorOpt.isPresent()) {
            Donor existingDonor = existingDonorOpt.get();
            existingDonor.setName(updatedDonor.getName());
            existingDonor.setEmail(updatedDonor.getEmail());
            existingDonor.setBloodType(updatedDonor.getBloodType());
            return donorRepository.save(existingDonor);
        }
        return null; // Or throw an exception
    }

    // Delete donor
    public void deleteDonor(String id) {
        donorRepository.deleteById(id);
    }

    // Find donor by email
    public Donor getDonorByEmail(String email) {
        return donorRepository.findByEmail(email);
    }

    // Check if donor is eligible to donate
    public Boolean checkEligibility(String id) {
        Optional<Donor> donorOpt = donorRepository.findById(id);
        if (donorOpt.isPresent()) {
            Donor donor = donorOpt.get();
            LocalDate lastDonationDate = LocalDate.parse(donor.getLastDonationDate());
            LocalDate eligibleDate = lastDonationDate.plusMonths(3); // Assuming a 3-month gap
            return LocalDate.now().isAfter(eligibleDate);
        }
        return false;
    }

    // Update last donation date
    public Donor updateLastDonationDate(String id, String donationDate) {
        Optional<Donor> donorOpt = donorRepository.findById(id);
        if (donorOpt.isPresent()) {
            Donor donor = donorOpt.get();
            donor.setLastDonationDate(donationDate);
            return donorRepository.save(donor);
        }
        return null;
    }
}
