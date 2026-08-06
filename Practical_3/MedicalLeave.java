package Practical_3;

public class MedicalLeave extends LeaveRequest{
    public MedicalLeave(int days, String facultyType, NotificationChannel channel) {
        super(days, facultyType, channel);
    }
    
    @Override
    public String getLeaveType() {
        return "Medical Leave";
    }
}
