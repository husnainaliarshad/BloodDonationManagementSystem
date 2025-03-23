package com.BDMS.BloodDonationManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BDMS.BloodDonationManagementSystem.Model.Notification;
import com.BDMS.BloodDonationManagementSystem.Service.NotificationService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Optional<Notification> getNotificationById(@PathVariable String id) {
        return notificationService.getNotificationById(id);
    }

    @GetMapping("/donor/{donorId}")
    public List<Notification> getNotificationsByDonor(@PathVariable String donorId) {
        return notificationService.getNotificationsByDonor(donorId);
    }

    @GetMapping("/unread")
    public List<Notification> getUnreadNotifications() {
        return notificationService.getUnreadNotifications();
    }

    @PostMapping
    public Notification createNotification(@RequestParam String donorId, @RequestParam String message) {
        return notificationService.createNotification(donorId, message);
    }

    @PutMapping("/{id}/mark-as-read")
    public Notification markAsRead(@PathVariable String id) {
        return notificationService.markAsRead(id);
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable String id) {
        notificationService.deleteNotification(id);
        return "Notification deleted successfully";
    }
}
