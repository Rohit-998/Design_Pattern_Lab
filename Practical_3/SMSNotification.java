package Practical_3;

public class SMSNotification implements NotificationChannel{
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notification " + message);
    }
}
