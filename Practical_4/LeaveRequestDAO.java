package Practical_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LeaveRequestDAO {

    // INSERT a new leave request
    public void insert(String facultyID, String leaveType, int noOfDays, String status) {
        String sql = "INSERT INTO LeaveRequest (FacultyID, LeaveType, NoOfDays, Status) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, facultyID);
            pstmt.setString(2, leaveType);
            pstmt.setInt(3, noOfDays);
            pstmt.setString(4, status);
            pstmt.executeUpdate();
            System.out.println("Inserted successfully: " + facultyID + " - " + leaveType);

        } catch (Exception e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // GET ALL leave requests
    public void getAll() {
        String sql = "SELECT * FROM LeaveRequest";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()
        ) {
            System.out.println("---------------------------------------------------");
            System.out.printf("%-12s %-18s %-10s %-10s%n", "FacultyID", "LeaveType", "NoOfDays", "Status");
            System.out.println("---------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-12s %-18s %-10d %-10s%n",
                    rs.getString("FacultyID"),
                    rs.getString("LeaveType"),
                    rs.getInt("NoOfDays"),
                    rs.getString("Status"));
            }

        } catch (Exception e) {
            System.out.println("Get all failed: " + e.getMessage());
        }
    }

    // GET BY FacultyID
    public void getByFacultyID(String facultyID) {
        String sql = "SELECT * FROM LeaveRequest WHERE FacultyID = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, facultyID);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Results for FacultyID: " + facultyID);
            System.out.println("---------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-12s %-18s %-10d %-10s%n",
                    rs.getString("FacultyID"),
                    rs.getString("LeaveType"),
                    rs.getInt("NoOfDays"),
                    rs.getString("Status"));
            }

        } catch (Exception e) {
            System.out.println("Get by ID failed: " + e.getMessage());
        }
    }

    // UPDATE status by FacultyID
    public void updateStatus(String facultyID, String newStatus) {
        String sql = "UPDATE LeaveRequest SET Status = ? WHERE FacultyID = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, newStatus);
            pstmt.setString(2, facultyID);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Updated " + facultyID + " status to: " + newStatus);
            } else {
                System.out.println("No record found for FacultyID: " + facultyID);
            }

        } catch (Exception e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    // DELETE by FacultyID
    public void delete(String facultyID) {
        String sql = "DELETE FROM LeaveRequest WHERE FacultyID = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, facultyID);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Deleted record for FacultyID: " + facultyID);
            } else {
                System.out.println("No record found for FacultyID: " + facultyID);
            }

        } catch (Exception e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }

    // DELETE ALL
    public void deleteAll() {
        String sql = "DELETE FROM LeaveRequest";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            int rows = pstmt.executeUpdate();
            System.out.println("Deleted all " + rows + " records from LeaveRequest table.");

        } catch (Exception e) {
            System.out.println("Delete all failed: " + e.getMessage());
        }
    }
}
