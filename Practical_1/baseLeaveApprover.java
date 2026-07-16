package Practical_1;


public interface baseLeaveApprover {
    void approveLeave(int days);
    void passItToHigherAuthority(int days);
    void handelRequest(int days);
}
