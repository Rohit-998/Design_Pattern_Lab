package Practical_3;

// done
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
    public String handelRequest(int days, String reason) {
        if (days <= 0) {
            System.out.println("PROXY: Invalid Request! Leave days must be positive.");
            return null;
        }
        if (!reason.equals("Medical Leave") && !reason.equals("Casual Leave") && !reason.equals("On Duty Leave") ) {
            System.out.println("PROXY: Invalid Request! Enter a valid reason");
            return null;
        }

        System.out.println("PROXY: Request validated. Forwarding to approvers...");
        return realApprover.handelRequest(days,reason);
    }
}
