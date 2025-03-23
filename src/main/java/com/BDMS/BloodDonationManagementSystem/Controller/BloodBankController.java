package com.BDMS.BloodDonationManagementSystem.Controller;

import com.BDMS.BloodDonationManagementSystem.Service.BloodBankService;
import com.BDMS.BloodDonationManagementSystem.Model.BloodBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bloodbanks")
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

    @GetMapping("/location/{location}")
    public BloodBank getBloodBankByLocation(@PathVariable String location) {
        return bloodBankService.getBloodBankByLocation(location);
    }

    @PostMapping
    public BloodBank createBloodBank(@RequestBody BloodBank bloodBank) {
        return bloodBankService.createBloodBank(bloodBank);
    }

    @PutMapping("/{id}/update-units")
    public BloodBank updateAvailableUnits(@PathVariable String id, @RequestParam int units) {
        return bloodBankService.updateAvailableUnits(id, units);
    }

    @DeleteMapping("/{id}")
    public String deleteBloodBank(@PathVariable String id) {
        bloodBankService.deleteBloodBank(id);
        return "Blood bank deleted successfully";
    }
}
