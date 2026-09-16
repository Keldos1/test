package org.example.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public EmailNotificationService emailNotificationService(){
        return new EmailNotificationService();
    }
    @Bean
    public NotificationController notificationController(NotificationService notificationService){
        return new NotificationController(notificationService);
    }
}
