package com.BDMS.BloodDonationManagementSystem.Controller;

import com.BDMS.BloodDonationManagementSystem.Model.Hospital;
import com.BDMS.BloodDonationManagementSystem.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping
    public List<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }

    @GetMapping("/{id}")
    public Optional<Hospital> getHospitalById(@PathVariable String id) {
        return hospitalService.getHospitalById(id);
    }

    @GetMapping("/name/{hospitalName}")
    public Hospital getHospitalByName(@PathVariable String hospitalName) {
        return hospitalService.getHospitalByName(hospitalName);
    }

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return hospitalService.createHospital(hospital);
    }

    @PutMapping("/{id}")
    public Hospital updateHospital(@PathVariable String id, @RequestBody Hospital hospital) {
        return hospitalService.updateHospital(id, hospital);
    }

    @DeleteMapping("/{id}")
    public String deleteHospital(@PathVariable String id) {
        hospitalService.deleteHospital(id);
        return "Hospital deleted successfully";
    }
}
