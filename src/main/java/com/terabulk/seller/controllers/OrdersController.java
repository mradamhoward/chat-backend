package com.terabulk.seller.controllers;

import com.terabulk.seller.models.Notification;
import com.terabulk.seller.models.SellerItem;
import com.terabulk.seller.repository.NotificationRepository;
import com.terabulk.seller.repository.SellerItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/seller/orders")
public class OrdersController {

    @Autowired
    private SellerItemRepo sellerItemRepo;

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/all")
    public List<SellerItem> getAllForSpecificSeller(@RequestParam String sellerId){
        return sellerItemRepo.findBySellerId(sellerId);
    }

    @PostMapping("/specific/dispatched")
    public void dispatchItem(@RequestParam String orderItemId){
        Notification notification = new Notification();
        notification.setMessage("Order " + orderItemId + " dispatched" );
        notification.setCreatedDate(new Date());
        notification.setEmail("info@terabulk.com");
        notification.setType("dispatched-notification");
        notificationRepository.save(notification);
    }
}
