package com.BDMS.BloodDonationManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/donor")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping
    public ResponseEntity<List<Donor>> donorController() {
        return new ResponseEntity<List<Donor>>(donorService.getAllDonors(), HttpStatus.OK);
    }
}
