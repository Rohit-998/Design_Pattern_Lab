package Practical_2;

public class proxyLeaveApprover implements baseLeaveApprover {

    private baseLeaveApprover realApprover;
    String reason;

    proxyLeaveApprover(baseLeaveApprover approver , String reason) {
        this.realApprover = approver;
        this.reason  = reason;
    }

    @Override
    public void approveLeave(int days , String reason) {
        realApprover.approveLeave(days , reason);
    }

    @Override
    public void passItToHigherAuthority(int days , String reason) {
        realApprover.passItToHigherAuthority(days, reason);
    }

    @Override
    public void handelRequest(int days, String reason) {
        if (days <= 0) {
            System.out.println("PROXY: Invalid Request! Leave days must be positive.");
            return;
        }
        if (!reason.equals("Medical") && !reason.equals("Casual") && !reason.equals("OnDuty") ) {
            System.out.println("PROXY: Invalid Request! Enter a valid reason");
            return;
        }

        System.out.println("PROXY: Request validated. Forwarding to approvers...");
        realApprover.handelRequest(days,reason);
    }
}
