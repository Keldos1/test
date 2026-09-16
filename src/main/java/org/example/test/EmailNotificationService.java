package org.example.test;
public class EmailNotificationService implements NotificationService{
    @Override
    public void send(String message){
        System.out.print("Email " + message);
    }
}
