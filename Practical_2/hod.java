package Practical_2;


public class hod implements baseLeaveApprover {

    private baseLeaveApprover higherAuthority; 

    public hod(baseLeaveApprover higherAuth) {
        this.higherAuthority = higherAuth;
        System.out.println("HOD Created");
    }

    @Override
    public void approveLeave(int days , String reason) {
        System.out.println("Leave Is Approved By HOD For " + days + " Days" + " For " + reason + " Leave");
    }

    @Override
    public void passItToHigherAuthority(int days, String reason) {
        System.out.println("HOD: Cannot approve " + days + " days. Passing to Principal...");
        higherAuthority.handelRequest(days , reason);
    }

    @Override
    public void handelRequest(int days, String reason) {
        if (days <= 2) {
            approveLeave(days,reason);
        } else {
            passItToHigherAuthority(days,reason);
        }
    }
}
