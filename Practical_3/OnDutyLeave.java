package Practical_3;

public class OnDutyLeave extends LeaveRequest {
    public OnDutyLeave(int days, String facultyType, NotificationChannel channel) {
        super(days, facultyType, channel);
    }
    
    @Override
    public String getLeaveType() {
        return "On Duty Leave";
    }

}
