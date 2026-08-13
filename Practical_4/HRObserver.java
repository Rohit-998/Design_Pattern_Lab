package Practical_4;



public class HRObserver implements Observer {

    @Override
    public void update(LeaveRequest request) {
        System.out.println("HR Department Notified: Update leave records - "
                + request.getLeaveType() + " for " + request.days + " days.");
    }
}
