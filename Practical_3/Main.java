package Practical_3;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                leaveManagementSystem lms = leaveManagementSystem.getLeaveManagementSystemInstance();
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter 1 for Permanent Faculty, 2 for Contract Faculty");
                int facultyChoice = sc.nextInt();

                LeaveRequestFactory leaveFactory;
                if (facultyChoice == 1) {
                        leaveFactory = new PermanentFacultyLeaveFactory();
                } else {
                        leaveFactory = new ContractFacultyLeaveFactory();
                }

                System.out.println("Enter 1 for Email, 2 for SMS, 3 for Mobile App");
                int channelChoice = sc.nextInt();

                NotificationChannel channel;
                if (channelChoice == 1) {
                        channel = new EmailNotification();
                } else if (channelChoice == 2) {
                        channel = new SMSNotification();
                } else {
                        channel = new MobileAppNotification();
                }

                System.out.println("Enter No of Days for Leave");
                int days = sc.nextInt();

                System.out.println("Enter 1 for Casual Leave, 2 for Medical Leave, 3 for On Duty Leave");
                int leaveChoice = sc.nextInt();

                LeaveRequest leaveRequest = null;
                if (leaveChoice == 1) {
                        leaveRequest = leaveFactory.createCasualLeave(days, channel);
                } else if (leaveChoice == 2) {
                        leaveRequest = leaveFactory.createMedicalLeave(days, channel);
                } else if (leaveChoice == 3) {
                        leaveRequest = leaveFactory.createOnDutyLeave(days, channel);
                }

                lms.approveLeave(leaveRequest);
        }
}
