package Practical_2;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                leaveManagementSystem leaveMangementSystem = leaveManagementSystem.getLeaveManagementSystemInstance();

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter No Days For The Leave");
                int days = sc.nextInt();
                System.out.println("Enter 1 For Medical Leave , 2 For Casual Leave , 3 For On Duty Leave");
                int reason = sc.nextInt();
                if (reason == 1) {
                        leaveMangementSystem.approveLeave(days, "Medical");
                } else if (reason == 2) {
                        leaveMangementSystem.approveLeave(days, "Casual");
                } else if (reason == 3) {
                        leaveMangementSystem.approveLeave(days, "OnDuty");
                }else{
                        leaveMangementSystem.approveLeave(days, "");
                }

               

        }
}
