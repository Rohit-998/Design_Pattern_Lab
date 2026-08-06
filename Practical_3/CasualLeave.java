package Practical_3;

public class CasualLeave extends LeaveRequest {
    
    public CasualLeave(int days, String facultyType, NotificationChannel channel) {
        super(days, facultyType, channel);
    }

    @Override
    public String getLeaveType() {
        return "Casual Leave";
    }



}
