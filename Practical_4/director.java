package Practical_4;

// done
public class director implements baseLeaveApprover {

    public director() {
        System.out.println("Director Created");
    }

    @Override
    public void approveLeave(int days , String reason) {
        System.out.println("Leave Is Approved By Director For " + days + " Days" + " For " + reason);
    }

    @Override
    public void passItToHigherAuthority(int days , String reason) {
       
        System.out.println("Director is the highest authority. No further escalation possible.");
    }

    @Override
    public String handelRequest(int days , String reason) {
        approveLeave(days,reason);
        return "Director";
    }
}
