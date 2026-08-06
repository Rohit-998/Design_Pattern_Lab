package Practical_2;


public interface baseLeaveApprover {
    void approveLeave(int days , String reason);
    void passItToHigherAuthority(int days , String reason );
    void handelRequest(int days, String reason);
}
