package com.BDMS.BloodDonationManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BDMS.BloodDonationManagementSystem.Repository.DonorRepository;
import com.BDMS.BloodDonationManagementSystem.Model.Donor;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private DonorRepository donorRepository;

    public boolean authenticateUser(String email, String password) {
        System.out.println("AUTHENTICATING USER: " + email);
        Optional<Donor> donorOpt = donorRepository.findByEmail(email);

        if (donorOpt.isEmpty()) {
            System.out.println("❌ Donor not found for email: " + email);
            return false;
        }

        Donor donor = donorOpt.get();
        System.out.println("✅ Donor found: " + donor.getEmail());

        if (donor.getPassword().equals(password)) {
            System.out.println("✅ Login successful!");
            return true;
        } else {
            System.out.println("❌ Incorrect password!");
            return false;
        }
    }

    // ✅ New method to register a donor
    public boolean registerDonor(Donor newDonor) {
        Optional<Donor> existingDonor = donorRepository.findByEmail(newDonor.getEmail());

        if (existingDonor.isPresent()) {
            System.out.println("❌ Signup failed: Email already exists!");
            return false;
        }

        donorRepository.save(newDonor);
        System.out.println("✅ Signup successful for: " + newDonor.getEmail());
        return true;
    }
}
