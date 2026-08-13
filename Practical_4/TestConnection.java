package Practical_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestConnection {
    public static void main(String[] args) {
        String sql = "SELECT * FROM LeaveRequest";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()
        ) {
            System.out.println("DB Connection Successful!");
            System.out.println("---------------------------------------------------");
            System.out.printf("%-12s %-18s %-10s %-10s%n", "FacultyID", "LeaveType", "NoOfDays", "Status");
            System.out.println("---------------------------------------------------");

            while (rs.next()) {
                String facultyID = rs.getString("FacultyID");
                String leaveType = rs.getString("LeaveType");
                int noOfDays = rs.getInt("NoOfDays");
                String status = rs.getString("Status");
                System.out.printf("%-12s %-18s %-10d %-10s%n", facultyID, leaveType, noOfDays, status);
            }

        } catch (Exception e) {
            System.out.println("DB Connection Failed!");
            e.printStackTrace();
        }
    }
}
