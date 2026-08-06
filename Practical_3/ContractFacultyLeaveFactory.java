package Practical_3;

public class ContractFacultyLeaveFactory implements LeaveRequestFactory {
  
        @Override
        public LeaveRequest createCasualLeave(int days, NotificationChannel channel) {
            System.out.println("Contract Faculty: Casual Leave request created for " + days + " days");
            return new CasualLeave(days, "Contract", channel);
        }

        @Override
        public LeaveRequest createMedicalLeave(int days, NotificationChannel channel) {
            System.out.println("Contract Faculty: Medical Leave is NOT allowed!");
            return null;
        }

        @Override
        public LeaveRequest createOnDutyLeave(int days, NotificationChannel channel) {
            System.out.println("Contract Faculty: On Duty Leave request created for " + days + " days");
            return new OnDutyLeave(days, "Contract", channel);
        }
    }
    

