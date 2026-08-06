package Practical_2;

public class factory {

  public baseLeaveApprover getChain(){
    director dir = new director();
    principal pri = new principal(dir);
    hod Hod = new hod(pri);
    return Hod;
  }
}
