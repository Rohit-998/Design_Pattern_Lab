package Practical_1;


public class principal implements baseLeaveApprover {

    private baseLeaveApprover higherAuthority; 
    private static principal instance;

  
    private principal(baseLeaveApprover higherAuth) {
        this.higherAuthority = higherAuth;
        System.out.println("Single Instance Of Principal Created");
    }

 
    public static principal getPrincipalInstance(baseLeaveApprover higherAuth) {
        if (instance == null) {
            instance = new principal(higherAuth);
        }
        return instance;
    }

    @Override
    public void approveLeave(int days) {
        System.out.println("Leave Is Approved By Principal For " + days + " Days");
    }

    @Override
    public void passItToHigherAuthority(int days) {
        System.out.println("Principal: Cannot approve " + days + " days. Passing to Director...");
        higherAuthority.handelRequest(days);
    }

    @Override
    public void handelRequest(int days) {
        if (days <= 7) {
            approveLeave(days);
        } else {
            passItToHigherAuthority(days);
        }
    }
}
