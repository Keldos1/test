package org.example.test;

import org.springframework.stereotype.Component;

@Component
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(){
        notificationService.send("Ваша заявка одобрена");
    }

}
