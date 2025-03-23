package com.BDMS.BloodDonationManagementSystem.Service;

import com.BDMS.BloodDonationManagementSystem.Model.Hospital;
import com.BDMS.BloodDonationManagementSystem.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Optional<Hospital> getHospitalById(String id) {
        return hospitalRepository.findById(id);
    }

    public Hospital getHospitalByName(String hospitalName) {
        return hospitalRepository.findByHospitalName(hospitalName);
    }

    public Hospital createHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public Hospital updateHospital(String id, Hospital updatedHospital) {
        Optional<Hospital> hospitalOpt = hospitalRepository.findById(id);
        if (hospitalOpt.isPresent()) {
            Hospital hospital = hospitalOpt.get();
            hospital.setHospitalName(updatedHospital.getHospitalName());
            hospital.setLocation(updatedHospital.getLocation());
            hospital.setContactNumber(updatedHospital.getContactNumber());
            return hospitalRepository.save(hospital);
        }
        return null;
    }

    public void deleteHospital(String id) {
        hospitalRepository.deleteById(id);
    }
}
