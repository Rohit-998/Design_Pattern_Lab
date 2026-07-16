package Practical_1;

public class Main {
    public static void main(String[] args) {
       leaveManagementSystem leaveMangementSystem = leaveManagementSystem.getLeaveManagementSystemInstance();
       
       System.out.println(
               "===================================== First Request For Days = 1 =====================================");
       leaveMangementSystem.approveLeave(1);

       System.out.println(
               "===================================== Second Request For Days = 5 =====================================");
       leaveMangementSystem.approveLeave(5);

      
       System.out.println(
               "===================================== Thrid Request For Days = 12 =====================================");
       leaveMangementSystem.approveLeave(12);

       
       System.out.println(
               "===================================== Fourth Request For Days = 2 =====================================");
       leaveMangementSystem.approveLeave(2);

    }
}
