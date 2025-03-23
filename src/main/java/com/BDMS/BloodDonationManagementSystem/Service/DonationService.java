package com.BDMS.BloodDonationManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BDMS.BloodDonationManagementSystem.Model.Donation;
import com.BDMS.BloodDonationManagementSystem.Repository.DonationRepository;
import com.BDMS.BloodDonationManagementSystem.Repository.DonorRepository;
import com.BDMS.BloodDonationManagementSystem.Repository.BloodBankRepository;
import com.BDMS.BloodDonationManagementSystem.Model.Donor;
import com.BDMS.BloodDonationManagementSystem.Model.BloodBank;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private BloodBankRepository bloodBankRepository;

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public Optional<Donation> getDonationById(String id) {
        return donationRepository.findById(id);
    }

    public List<Donation> getDonationsByDonor(String donorId) {
        return donationRepository.findByDonorId(donorId);
    }

    public List<Donation> getDonationsByBloodBank(String bloodBankId) {
        return donationRepository.findByBloodBankId(bloodBankId);
    }

    public Donation createDonation(Donation donation) {
        // Update donor's last donation date
        Optional<Donor> donorOpt = donorRepository.findById(donation.getDonorId());
        if (donorOpt.isPresent()) {
            Donor donor = donorOpt.get();
            donor.setLastDonationDate(donation.getDonationDate());
            donorRepository.save(donor);
        }

        // Reduce available blood units in BloodBank
        Optional<BloodBank> bloodBankOpt = bloodBankRepository.findById(donation.getBloodBankId());
        if (bloodBankOpt.isPresent()) {
            BloodBank bloodBank = bloodBankOpt.get();
            bloodBank.setAvailableUnits(bloodBank.getAvailableUnits() + donation.getQuantity());
            bloodBankRepository.save(bloodBank);
        }

        return donationRepository.save(donation);
    }

    public void deleteDonation(String id) {
        donationRepository.deleteById(id);
    }
}
