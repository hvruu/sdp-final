package strategy;

public class Halyk implements PaymentStrategy {
    private String cardNumber;

    public Halyk(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with credit card: " + cardNumber);
    }
}
