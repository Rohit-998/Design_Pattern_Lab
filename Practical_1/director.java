package Practical_1;


public class director implements baseLeaveApprover {

    public director() {
        System.out.println("Director Created");
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
