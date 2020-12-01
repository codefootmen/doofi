package utils;

public class NotificationObserver implements Observer {
    @Override
    public void update() {
        System.out.println("NOTIFICATION TRIGGERED");
    }
}
