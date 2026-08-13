package Practical_4;

public class HODObserve implements Observer {
    @Override
    public void update(LeaveRequest request) {
        System.out.println("HOD Notified: " + request.getLeaveType()
                + " for " + request.days + " days approved in your department.");
    }
}
