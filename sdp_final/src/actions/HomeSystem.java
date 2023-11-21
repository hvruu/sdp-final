package actions;

import observer.HomeObserver;
import singleton.Logger;
import java.util.ArrayList;
import java.util.List;

public class HomeSystem {
    private Logger logger = Logger.getInstance();
    private List<HomeObserver> guard = new ArrayList<>();
    private List<HomeObserver> family = new ArrayList<>();
    private boolean nobodyHome = false;

    public void addSecurity(HomeObserver observer) {
        guard.add(observer);
    }

    public void removeSecurity(HomeObserver observer) {
        guard.remove(observer);
    }

    public void addFamily(HomeObserver observer) {
        family.add(observer);
    }

    public void removeFamily(HomeObserver observer) {
        family.remove(observer);
    }

    public void openDoor() {
        System.out.println("\n\nThe Door opens..");
        logger.log("The Door opened");

        if (nobodyHome) {
            notifyFamily("Good day, it seems there is an outsider in the house. I strongly advise you to do something!");
            notifySecurity("the house has been invaded!");
            callPolice();
        } else {
            notifySecurity("Door opened");
        }
    }

    public void closeDoor() {
        System.out.println("\n\nThe Door closes..");
        logger.log("The Door closed");
        notifySecurity("Door closed");
    }

    public void lightsON(String room) {
        System.out.println("\n\nThe light turns on in the " + room);
        logger.log(room + " : Lights off");
        notifySecurity("Lights ON in " + room);
    }

    public void lightsOFF(String room) {
        System.out.println("\n\nThe light turns off in the " + room);
        logger.log(room + " : Lights ON");
        notifySecurity("Lights OFF in " + room);
    }

    public void callPolice(){

    }

    private void notifySecurity(String action) {
        for (HomeObserver observer : guard) {
            observer.update(action);
        }
    }

    private void notifyFamily(String action) {
        for (HomeObserver observer : family) {
            observer.update(action);
        }
    }

    public void setNobodyHome(boolean nobodyHome) {
        this.nobodyHome = nobodyHome;
    }
}
