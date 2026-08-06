package Practical_2;

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

    public void approveLeave(int days , String reason) {

        factory f = new factory();
        baseLeaveApprover chain = f.getChain();
        proxyLeaveApprover prxoy = new proxyLeaveApprover(chain , reason);
        prxoy.handelRequest(days, reason);

    }

}
