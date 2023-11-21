package actions;

import singleton.Logger;
import strategy.PaymentStrategy;

public class PaymentAssistant {
    private Logger logger = Logger.getInstance();
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
            logger.log("Payment processed using the " + getStrategyName() + " strategy. amount: " + amount);
        } else {
            System.out.println("Payment strategy not set. Please set a payment strategy first.");
        }
    }

    public String getStrategyName() {
        return (paymentStrategy != null) ? paymentStrategy.getClass().getSimpleName() : "No strategy";
    }
}
