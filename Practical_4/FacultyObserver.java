package Practical_4;

public class FacultyObserver implements Observer {
    @Override
    public void update(LeaveRequest request){
        System.out.println("Faculty Notified: Your " + request.getLeaveType()
                + " for " + request.days + " days has been approved.");
        
    }
}
