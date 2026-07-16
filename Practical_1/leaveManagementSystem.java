package Practical_1;

public class leaveManagementSystem {

    

    private static leaveManagementSystem instance;

    private leaveManagementSystem() {
       
        System.out.println("Single Instance for Leave Management System is Created");
    }

    

    public static leaveManagementSystem getLeaveManagementSystemInstance() {
        if (instance == null) {
            instance = new leaveManagementSystem();
        }
        return instance;
    }

    public void approveLeave(int days) {


        director dir = director.getDirectorInstance();

        principal prin = principal.getPrincipalInstance(dir);

        hod hodInstance = hod.getHodInstance(prin);

        hodInstance.handelRequest(days);
    }

}
