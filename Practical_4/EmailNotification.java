package Practical_4;

public class EmailNotification implements NotificationChannel{
    @Override
   public void sendNotification(String message){
        System.out.println("Email Notification " + message);
    }

}
