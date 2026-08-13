package Practical_4;

// done
public class principal implements baseLeaveApprover {

    private baseLeaveApprover higherAuthority; 

    public principal(baseLeaveApprover higherAuth) {
        this.higherAuthority = higherAuth;
        System.out.println("Principal Created");
    }

    @Override
    public void approveLeave(int days , String reason) {
        System.out.println("Leave Is Approved By Principal For " + days + " Days" + " For " + reason );
    }

    @Override
    public void passItToHigherAuthority(int days , String reason) {
        System.out.println("Principal: Cannot approve " + days + " days. Passing to Director...");
    }

    @Override
    public String handelRequest(int days, String reason) {
        if (days <= 7) {
            approveLeave(days,reason);
            return "Principal";

        } else {
            passItToHigherAuthority(days,reason);
            return higherAuthority.handelRequest(days, reason);
        }
    }
}
