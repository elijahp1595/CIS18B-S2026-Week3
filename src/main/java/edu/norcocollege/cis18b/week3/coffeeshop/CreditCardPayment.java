package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

public class CreditCardPayment implements PaymentMethod {
    private String last4;

    public CreditCardPayment(String last4) {
        if (last4 == null || last4.length() != 4) {
            throw new IllegalArgumentException("last4 must be exactly 4 characters");
        }
        this.last4 = last4;
    }

    @Override
    public PaymentReceipt pay(String orderId, BigDecimal amount) {
        String method = "CREDIT_CARD(****" + last4 + ")"; // Added the 4th asterisk
        return new PaymentReceipt(orderId, amount, method, Instant.now());
    }
}