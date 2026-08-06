package Practical_3;

public abstract class LeaveRequest {

    protected int days;
    protected String facultyType;
    protected NotificationChannel channel;

    public LeaveRequest(int days, String facultyType, NotificationChannel channel) {
        this.days = days;
        this.facultyType = facultyType;
        this.channel = channel;
    }

    public abstract String getLeaveType();

    public void notifyApproval(String approvedBy) {
        String message = getLeaveType() + " for " + days + " days approved by " + approvedBy
                + " for " + facultyType + " Faculty";
        channel.sendNotification(message);
    }

}
