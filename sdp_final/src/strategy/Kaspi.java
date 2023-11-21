package strategy;

public class Kaspi implements PaymentStrategy {
    private String cardNumber;

    public Kaspi(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with credit card: " + cardNumber);
    }
}
