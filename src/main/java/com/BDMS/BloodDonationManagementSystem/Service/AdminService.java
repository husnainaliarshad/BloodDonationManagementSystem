package com.BDMS.BloodDonationManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BDMS.BloodDonationManagementSystem.Model.Admin;
import com.BDMS.BloodDonationManagementSystem.Repository.AdminRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(String id) {
        return adminRepository.findById(id);
    }

    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(String id, Admin updatedAdmin) {
        Optional<Admin> adminOpt = adminRepository.findById(id);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            admin.setName(updatedAdmin.getName());
            admin.setEmail(updatedAdmin.getEmail());
            admin.setAdminCode(updatedAdmin.getAdminCode());
            return adminRepository.save(admin);
        }
        return null;
    }

    public void deleteAdmin(String id) {
        adminRepository.deleteById(id);
    }
}
