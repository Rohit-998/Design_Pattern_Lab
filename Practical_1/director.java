package Practical_1;


public class director implements baseLeaveApprover {

    private static director instance;

  
    private director() {
        System.out.println("Single Instance Of Director Created");
    }

    
    public static director getDirectorInstance() {
        if (instance == null) {
            instance = new director();
        }
        return instance;
    }

    @Override
    public void approveLeave(int days) {
        System.out.println("Leave Is Approved By Director For " + days + " Days");
    }

    @Override
    public void passItToHigherAuthority(int days) {
       
        System.out.println("Director is the highest authority. No further escalation possible.");
    }

    @Override
    public void handelRequest(int days) {
        approveLeave(days);
    }
}
