package com.BDMS.BloodDonationManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BloodBankService {
    @Autowired
    private BloodBankRepository bloodBankRepository;

    public List<BloodBank> getAllBloodBanks() {
        return bloodBankRepository.findAll();
    }

    public Optional<BloodBank> getBloodBankById(String id) {
        return bloodBankRepository.findById(id);
    }

    public BloodBank createBloodBank(BloodBank bloodBank) {
        return bloodBankRepository.save(bloodBank);
    }

    public void deleteBloodBank(String id) {
        bloodBankRepository.deleteById(id);
    }
}