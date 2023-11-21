package observer;

import actions.HomeSystem;

public class SecurityObserver implements HomeObserver {
    private String name;

    public SecurityObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String action) {
        System.out.println("Smart home: " + action);
    }
}

