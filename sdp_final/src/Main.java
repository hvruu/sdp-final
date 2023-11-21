import actions.HomeSystem;
import actions.PaymentAssistant;
import observer.SecurityObserver;
import singleton.Logger;
import strategy.Kaspi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import observer.HomeObserver;
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        HomeSystem sys = new HomeSystem();
        PaymentAssistant payAssistant = new PaymentAssistant();
        Menu menu = new Menu();

        Scanner scanner = new Scanner(System.in);


        System.out.println("Register first before using Smart Home options.");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("\nPassword: ");
        String password = scanner.nextLine();
        System.out.print("\n");
        if(menu.registerMenu(login, password)){
            menu.MainMenuChoice();
        }

/*        System.out.print("Enter your credit card number: ");
        String cardNumber = scanner.nextLine();

        payAssistant.setPaymentStrategy(new Kaspi(cardNumber));
        payAssistant.processPayment(50.0);*/



/*        List<String> familyMembers = Arrays.asList("Mother", "Father", "Son");

        for (String name : familyMembers) {
            HomeObserver familyMember = new SecurityObserver(name);
            sys.addFamily(familyMember);
        }

        List<String> securities = Arrays.asList("Security1", "Security2");

        for (String name : securities) {
            HomeObserver security = new SecurityObserver(name);
            sys.addSecurity(security);
        }

        sys.openDoor();
        sys.closeDoor();
        sys.setNobodyHome(true);
        sys.openDoor();*/



        logger.close();
    }
}