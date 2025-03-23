package com.BDMS.BloodDonationManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor getDonorById(String id) {
        return donorRepository.findById(id).orElse(null);
    }

    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }
}

