package com.BDMS.BloodDonationManagementSystem.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.BDMS.BloodDonationManagementSystem.Model.Notification;
import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByDonorId(String donorId);
    List<Notification> findByIsRead(boolean isRead);
}
