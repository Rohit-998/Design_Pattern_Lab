package Practical_3;

public interface LeaveRequestFactory {
    LeaveRequest createCasualLeave(int days, NotificationChannel channel);

    LeaveRequest createMedicalLeave(int days, NotificationChannel channel);

    LeaveRequest createOnDutyLeave(int days, NotificationChannel channel);
}
