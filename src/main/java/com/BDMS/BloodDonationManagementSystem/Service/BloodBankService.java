package com.BDMS.BloodDonationManagementSystem.Service;
import com.BDMS.BloodDonationManagementSystem.Model.BloodBank;
import com.BDMS.BloodDonationManagementSystem.Repository.BloodBankRepository;
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

    public BloodBank getBloodBankByLocation(String location) {
        return bloodBankRepository.findByLocation(location);
    }

    public BloodBank createBloodBank(BloodBank bloodBank) {
        return bloodBankRepository.save(bloodBank);
    }

    public BloodBank updateAvailableUnits(String id, int units) {
        Optional<BloodBank> bloodBankOpt = bloodBankRepository.findById(id);
        if (bloodBankOpt.isPresent()) {
            BloodBank bloodBank = bloodBankOpt.get();
            bloodBank.setAvailableUnits(units);
            return bloodBankRepository.save(bloodBank);
        }
        return null; // Or throw an exception
    }

    public void deleteBloodBank(String id) {
        bloodBankRepository.deleteById(id);
    }
}
