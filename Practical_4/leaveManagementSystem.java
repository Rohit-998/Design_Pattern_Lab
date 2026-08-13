package Practical_4;


public class leaveManagementSystem {

    private static leaveManagementSystem instance;
    private LeaveCoordinator coordinator;

    private leaveManagementSystem() {
        System.out.println("Single Instance for Leave Management System is Created");

        coordinator = new LeaveCoordinator();
        coordinator.addObserver(new FacultyObserver());
        coordinator.addObserver(new HODObserve());
        coordinator.addObserver(new HRObserver());
        coordinator.addObserver(new AccountsObserver());
    }

    public static leaveManagementSystem getLeaveManagementSystemInstance() {
        if (instance == null) {
            instance = new leaveManagementSystem();
        }
        return instance;
    }

    public boolean approveLeave(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            System.out.println("Leave request is invalid. Cannot process.");
            return false;
        }

        int days = leaveRequest.days;
        String reason = leaveRequest.getLeaveType();


        factory f = new factory();
        baseLeaveApprover chain = f.getChain();
        proxyLeaveApprover prxoy = new proxyLeaveApprover(chain, reason);
        String approvedBy = prxoy.handelRequest(days, reason);

        if (approvedBy != null) {
            leaveRequest.notifyApproval(approvedBy);
            coordinator.notifyObservers(leaveRequest);
            return true;
        }
        return false;
    }

}
