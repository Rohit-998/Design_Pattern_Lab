package Practical_1;


public class hod implements baseLeaveApprover {

    private baseLeaveApprover higherAuthority; 
    private static hod instance;

    
    private hod(baseLeaveApprover higherAuth) {
        this.higherAuthority = higherAuth;
        System.out.println("Single Instance Of HOD Created");
    }

    
    public static hod getHodInstance(baseLeaveApprover higherAuth) {
        if (instance == null) {
            instance = new hod(higherAuth);
        }
        return instance;
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
