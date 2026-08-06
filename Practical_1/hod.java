package Practical_1;


public class hod implements baseLeaveApprover {

    private baseLeaveApprover higherAuthority; 

    public hod(baseLeaveApprover higherAuth) {
        this.higherAuthority = higherAuth;
        System.out.println("HOD Created");
    }

    @Override
    public void approveLeave(int days) {
        System.out.println("Leave Is Approved By HOD For " + days + " Days");
    }

    @Override
    public void passItToHigherAuthority(int days) {
        System.out.println("HOD: Cannot approve " + days + " days. Passing to Principal...");
        higherAuthority.handelRequest(days);
    }

    @Override
    public void handelRequest(int days) {
        if (days <= 2) {
            approveLeave(days);
        } else {
            passItToHigherAuthority(days);
        }
    }
}
