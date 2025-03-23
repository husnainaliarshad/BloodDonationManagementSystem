package com.BDMS.BloodDonationManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BDMS.BloodDonationManagementSystem.Service.AuthService;
import com.BDMS.BloodDonationManagementSystem.Model.Donor;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // ✅ Allow frontend requests
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (authService.authenticateUser(email, password)) {
            return Map.of("message", "Login successful", "token", "dummy-jwt-token");
        } else {
            return Map.of("message", "Invalid credentials");
        }
    }

    // ✅ New Signup Endpoint
    @PostMapping("/signup")
    public Map<String, String> signup(@RequestBody Donor newDonor) {
        boolean success = authService.registerDonor(newDonor);

        if (success) {
            return Map.of("message", "Signup successful! You can now log in.");
        } else {
            return Map.of("message", "Signup failed! Email already exists.");
        }
    }
}
