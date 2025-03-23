package com.BDMS.BloodDonationManagementSystem.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.BDMS.BloodDonationManagementSystem.Model.User;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
