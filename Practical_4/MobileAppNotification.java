package Practical_4;

public class MobileAppNotification implements NotificationChannel {
    @Override
       public void sendNotification(String message) {
        System.out.println("Mobile App Notification " + message);
    }
}
