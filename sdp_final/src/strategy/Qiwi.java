package strategy;

public class Qiwi implements PaymentStrategy {
    private String number;

    public Qiwi(String Number) {
        this.number = Number;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with credit card: " + number);
    }
}
