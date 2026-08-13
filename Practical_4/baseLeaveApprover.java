package Practical_4;


public interface baseLeaveApprover {
    void approveLeave(int days, String reason);

    void passItToHigherAuthority(int days, String reason);

    String handelRequest(int days, String reason);
}
