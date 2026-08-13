package Practical_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                leaveManagementSystem lms = leaveManagementSystem.getLeaveManagementSystemInstance();
                Scanner sc = new Scanner(System.in);
                LeaveRequestDAO dao = new LeaveRequestDAO();

                
                System.out.println("\n=== Pending Leave Requests from Database ===");
                dao.getAll();

             
                System.out.println("\nEnter FacultyID to process (e.g. PF001, CF001): ");
                String facultyID = sc.next();

                
                LeaveRequestFactory leaveFactory;
                if (facultyID.startsWith("PF")) {
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

               
                try (
                                Connection conn = DBConnection.getConnection();
                                PreparedStatement pstmt = conn.prepareStatement(
                                                "SELECT * FROM LeaveRequest WHERE FacultyID = ? AND Status = 'Pending'")) {
                        pstmt.setString(1, facultyID);
                        ResultSet rs = pstmt.executeQuery();

                        if (rs.next()) {
                                String leaveType = rs.getString("LeaveType");
                                int days = rs.getInt("NoOfDays");

                             
                                LeaveRequest leaveRequest = null;
                                if (leaveType.equals("Casual Leave")) {
                                        leaveRequest = leaveFactory.createCasualLeave(days, channel);
                                } else if (leaveType.equals("Medical Leave")) {
                                        leaveRequest = leaveFactory.createMedicalLeave(days, channel);
                                } else if (leaveType.equals("On Duty Leave")) {
                                        leaveRequest = leaveFactory.createOnDutyLeave(days, channel);
                                }

                                boolean isApproved = lms.approveLeave(leaveRequest);

                              
                                if (isApproved) {
                                        dao.updateStatus(facultyID, "Approved");
                                } else {
                                        dao.updateStatus(facultyID, "Rejected");
                                }
                        } else {
                                System.out.println("No pending request found for " + facultyID);
                        }

                } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                }

                
                System.out.println("\n=== Updated Leave Requests ===");
                dao.getAll();
        }
}
