package com.BDMS.BloodDonationManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BDMS.BloodDonationManagementSystem.Model.Notification;
import com.BDMS.BloodDonationManagementSystem.Repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(String id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getNotificationsByDonor(String donorId) {
        return notificationRepository.findByDonorId(donorId);
    }

    public List<Notification> getUnreadNotifications() {
        return notificationRepository.findByIsRead(false);
    }

    public Notification createNotification(String donorId, String message) {
        Notification notification = new Notification();
        notification.setDonorId(donorId);
        notification.setMessage(message);
        notification.setIsRead(false);
        notification.setTimestamp(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public Notification markAsRead(String id) {
        Optional<Notification> notificationOpt = notificationRepository.findById(id);
        if (notificationOpt.isPresent()) {
            Notification notification = notificationOpt.get();
            notification.setIsRead(true);
            return notificationRepository.save(notification);
        }
        return null;
    }

    public void deleteNotification(String id) {
        notificationRepository.deleteById(id);
    }
}
