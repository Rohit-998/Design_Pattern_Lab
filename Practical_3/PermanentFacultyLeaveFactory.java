package Practical_3;

public class PermanentFacultyLeaveFactory implements LeaveRequestFactory {


    @Override
    public LeaveRequest createCasualLeave(int days, NotificationChannel channel) {
        System.out.println("Permanent Faculty: Casual Leave request created for " + days + " days");
        return new CasualLeave(days, "Permanent", channel);
    }
    
    @Override
    public LeaveRequest createMedicalLeave(int days, NotificationChannel channel) {
        System.out.println("Permanent Faculty: Medical Leave request created for " + days + " days");
        return new MedicalLeave(days, "Permanent", channel);
    }
    
    @Override
    public LeaveRequest createOnDutyLeave(int days, NotificationChannel channel) {
        System.out.println("Permanent Faculty: On Duty Leave request created for " + days + " days");
        return new OnDutyLeave(days, "Permanent", channel);
    }
    



    
}
