package com.terabulk.seller.controllers;

import com.terabulk.seller.models.Notification;
import com.terabulk.seller.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @PutMapping("notifications/set/seen")
    public List<Notification> setNotifcationsSeen(@RequestBody List<String> ids){
        ArrayList<Notification> notificationArrayList = new ArrayList<>();
        List<Notification> notifications = (List<Notification>) notificationRepository.findAllById(ids);
        for(Notification notification : notifications){
            notification.setSeen(true);
        }
        notificationRepository.saveAll(notifications);
        return notifications;
    }
}
