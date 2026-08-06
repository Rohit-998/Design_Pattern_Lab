package Practical_3;

// done
public class hod implements baseLeaveApprover {

    private baseLeaveApprover higherAuthority; 

    public hod(baseLeaveApprover higherAuth) {
        this.higherAuthority = higherAuth;
        System.out.println("HOD Created");
    }

    @Override
    public void approveLeave(int days , String reason) {
        System.out.println("Leave Is Approved By HOD For " + days + " Days" + " For " + reason);
    }

    @Override
    public void passItToHigherAuthority(int days, String reason) {
        System.out.println("HOD: Cannot approve " + days + " days. Passing to Principal...");
    }

    @Override
    public String handelRequest(int days, String reason) {
        if (days <= 2) {
            approveLeave(days,reason);
            return "HOD";
        } else {
            passItToHigherAuthority(days,reason);
            return higherAuthority.handelRequest(days, reason);
        }
    }
}
