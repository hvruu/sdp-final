import Factory.BabysitterServant;
import Factory.BabysitterServantFactory;
import Factory.GardenerServant;
import Factory.GardenerServantFactory;
import Factory.MaidServant;
import Factory.MaidServantFactory;
import Factory.Servant;
import Factory.ServantFactory;

import singleton.Logger;
import strategy.Qiwi;
import strategy.Kaspi;
import strategy.Halyk;

import actions.HomeSystem;
import actions.PaymentAssistant;
import decorator.*;
import observer.HomeObserver;
import observer.SecurityObserver;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    Logger logger = Logger.getInstance();
    HomeSystem sys = new HomeSystem();
    Food food = null;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public boolean registerMenu(String login, String password) {
        if ("1".equals(login) && "1".equals(password)) {
            return true;
        }
        return false;
    }


    public void showMainMenu() {
        System.out.println("\n\n\n\nMain Menu:");
        System.out.println("1. Prepare Food");
        System.out.println("2. Add member to Family List");
        System.out.println("3. Add member to Security List");
        System.out.println("4. Servants");
        System.out.println("5. Exit");
    }

    public void PrepareFoodMenu() {
        System.out.println("\n\n\n\nPrepare Food:");
        System.out.println("choose the food to cook");
        System.out.println("1. Mantas");
        System.out.println("2. Dumplings");
    }

    public void SpicesMenu() {
        System.out.println("\n\n\n\nWhat spices do you want to add to");
        System.out.println("1. Ketchup");
        System.out.println("2. Mayonnaise");
        System.out.println("3. Back to Main Menu");
    }

    public void ServantMenu(){
        System.out.println("\n\n\n\nWhat service do you need at the moment");
        System.out.println("1. Babysitter (cost: $30)");
        System.out.println("2. Clean (cost: $20)");
        System.out.println("3. Gardener (cost: $10)");
        System.out.println("4. Back to Main Menu");
    }

    public void SelectPayMethod(double amount){
        PaymentAssistant assistant = new PaymentAssistant();
        System.out.println("You need to pay $" + amount);
        System.out.println("choose a payment method: ");
        System.out.println("1. Halyk");
        System.out.println("2. Kaspi");
        System.out.println("3. Qiwi");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                assistant.setPaymentStrategy(new Halyk("1234-5678-9101-1121"));
                break;
            case 2:
                assistant.setPaymentStrategy(new Kaspi("2222-3333-4444-5555"));
                break;
            case 3:
                assistant.setPaymentStrategy(new Qiwi("987654321"));
                break;
            default:
                System.out.println("Invalid choice. No payment strategy selected.");
        }
        assistant.processPayment(amount);
    }

    public void MainMenuChoice() {
        int mainChoice;
        do {
            showMainMenu();
            mainChoice = getUserChoice();

            switch (mainChoice) {
                case 1:
                    PrepareFoodChoise();
                    break;
                case 2:
                    System.out.println("Enter the name of the family member:");
                    String familyName = scanner.next();
                    HomeObserver familyObserver = new SecurityObserver(familyName);
                    sys.addFamily(familyObserver);
                    break;
                case 3:
                    System.out.println("");
                    String securityName = scanner.next();
                    HomeObserver securityObserver = new SecurityObserver(securityName);
                    sys.addFamily(securityObserver);
                    break;
                case 4:
                    ServantChoice(0);
                case 5:
                    System.out.println("Exiting. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (mainChoice != 5);
    }


    private void ServantChoice(double pay){
        int choice;

        do {
            ServantMenu();
            choice = getUserChoice();

            switch (choice){
                case 1:
                    ServantFactory factorySitter = new BabysitterServantFactory();
                    Servant servantSitter = factorySitter.createServant();
                    servantSitter.performTask();
                    logger.log("the babysitter is called\n");
                    pay += 30;
                    ServantChoice(pay);
                    break;
                case 2:
                    ServantFactory factoryMaid = new MaidServantFactory();
                    Servant servantMaid = factoryMaid.createServant();
                    servantMaid.performTask();
                    logger.log("the maid is called\n");
                    pay += 20;
                    ServantChoice(pay);
                    break;
                case 3:
                    ServantFactory factoryGarden = new GardenerServantFactory();
                    Servant servantGarden = factoryGarden.createServant();
                    servantGarden.performTask();
                    logger.log("the gardener is called\n");
                    pay += 10;
                    ServantChoice(pay);
                    break;
                case 4:
                    PaymentAssistant assistant = new PaymentAssistant();
                    System.out.println("Returning to Main Menu.");
                    if(pay != 0)
                        SelectPayMethod(pay);
                    MainMenuChoice();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while ( choice != 4 );
    }

    private void PrepareFoodChoise() {
        int subChoice;
        while (true){
            PrepareFoodMenu();
            subChoice = getUserChoice();

            switch (subChoice) {
                case 1:
                    food = new Mantas();
                    Spices();
                    break;
                case 2:
                    food = new Dumplings();
                    Spices();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private void Spices() {
        int SpicesChoise;
        do {
            SpicesMenu();
            SpicesChoise = getUserChoice();

            switch (SpicesChoise) {
                case 1:
                    food = new Ketchup(food);
                    Spices();
                    break;
                case 2:
                    food = new Mayonnaise(food);
                    Spices();
                    break;
                case 3:
                    System.out.println("\n\nYour " + food.getDescription() + " order. It will be ready in " + food.prepareTime() + " minutes");
                    logger.log("order: " + food.getDescription() + " is ordered. It takes "+ food.prepareTime() + " minutes\n");
                    System.out.println("Returning to Main Menu.");
                    MainMenuChoice();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (SpicesChoise != 3);
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

}
