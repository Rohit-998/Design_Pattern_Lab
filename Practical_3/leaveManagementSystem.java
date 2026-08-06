package Practical_3;

// done
public class leaveManagementSystem {

    private static leaveManagementSystem instance;

    private leaveManagementSystem() {

        System.out.println("Single Instance for Leave Management System is Created");
    }

    public static leaveManagementSystem getLeaveManagementSystemInstance() {
        if (instance == null) {
            instance = new leaveManagementSystem();
        }
        return instance;
    }

    public void approveLeave(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            System.out.println("Leave request is invalid. Cannot process.");
            return;
        }

        int days = leaveRequest.days;
        String reason = leaveRequest.getLeaveType();


        factory f = new factory();
        baseLeaveApprover chain = f.getChain();
        proxyLeaveApprover prxoy = new proxyLeaveApprover(chain, reason);
        String approvedBy = prxoy.handelRequest(days, reason);

        if (approvedBy != null) {
            leaveRequest.notifyApproval(approvedBy);
        }

    }

}
