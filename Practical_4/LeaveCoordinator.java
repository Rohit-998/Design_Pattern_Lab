package Practical_4;

import java.util.ArrayList;
import java.util.List;

public class LeaveCoordinator {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs) {
        observers.add(obs);
        System.out.println(obs.getClass().getSimpleName() + " registered as observer.");
    }
    
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println(observer.getClass().getSimpleName() + " removed from observers.");
    }
    
    public void notifyObservers(LeaveRequest request) {
        System.out.println("\n--- Notifying all observers ---");
        for (Observer observer : observers) {
            observer.update(request);
        }
        System.out.println("--- All observers notified ---\n");
    }
}
