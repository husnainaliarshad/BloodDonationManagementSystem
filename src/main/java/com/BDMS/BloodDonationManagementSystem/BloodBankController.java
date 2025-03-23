package com.BDMS.BloodDonationManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blood_banks")
public class BloodBankController {
    @Autowired
    private BloodBankService bloodBankService;

    @GetMapping
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankService.getAllBloodBanks();
    }

    @GetMapping("/{id}")
    public Optional<BloodBank> getBloodBankById(@PathVariable String id) {
        return bloodBankService.getBloodBankById(id);
    }

    @PostMapping
    public BloodBank createBloodBank(@RequestBody BloodBank bloodBank) {
        return bloodBankService.createBloodBank(bloodBank);
    }

    @DeleteMapping("/{id}")
    public void deleteBloodBank(@PathVariable String id) {
        bloodBankService.deleteBloodBank(id);
    }
}

