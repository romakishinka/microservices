package com.amigoscode.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("NOTIFICATION")
public interface NotificationClient {
    @PostMapping(path = "api/v1/notification")
    void saveNotification(NotificationRequest notificationRequest);
}
