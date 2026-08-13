package Practical_4;

public class AccountsObserver implements Observer {

    @Override
    public void update(LeaveRequest request) {
        System.out.println("Accounts Department Notified: Process salary deduction for "
                + request.days + " days of " + request.getLeaveType() + ".");
    }
}
