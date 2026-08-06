package Practical_2;


public class principal implements baseLeaveApprover {

    private baseLeaveApprover higherAuthority; 

    public principal(baseLeaveApprover higherAuth) {
        this.higherAuthority = higherAuth;
        System.out.println("Principal Created");
    }

    @Override
    public void approveLeave(int days , String reason) {
        System.out.println("Leave Is Approved By Principal For " + days + " Days" + " For " + reason + " Leave" );
    }

    @Override
    public void passItToHigherAuthority(int days , String reason) {
        System.out.println("Principal: Cannot approve " + days + " days. Passing to Director...");
        higherAuthority.handelRequest(days,reason);
    }

    @Override
    public void handelRequest(int days, String reason) {
        if (days <= 7) {
            approveLeave(days,reason);
        } else {
            passItToHigherAuthority(days,reason);
        }
    }
}
