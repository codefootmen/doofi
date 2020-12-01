package utils;

import java.util.ArrayList;
import java.util.List;

public class NotificationEmitter {
    private static final List<Observer> observers = new ArrayList<>();

    public static void addObserver(Observer o) {
        observers.add(o);
    }

    public static void emit() {
        notifyObservers();
    }

    private static void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}
