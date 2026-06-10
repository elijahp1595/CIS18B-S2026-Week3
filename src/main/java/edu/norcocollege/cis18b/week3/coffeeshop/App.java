package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Coffee Shop Terminal ---");

        Order order = new Order("ORD-001");

        Beverage latte = new Latte("L-01", "Classic Latte", Beverage.Size.LARGE);
        Beverage coldBrew = new ColdBrew("CB-01", "House Cold Brew", Beverage.Size.MEDIUM);
        order.addItem(latte);
        order.addItem(coldBrew);

        CustomDrink custom = new CustomDrink.Builder("CUST-01", "Developer Special")
                .size(Beverage.Size.LARGE)
                .milk(CustomDrink.Milk.OAT)
                .syrup(CustomDrink.Syrup.CARAMEL)
                .espressoShots(3)
                .addExtra("Whipped Cream")
                .build();
        order.addItem(custom);

        System.out.println("\nOrder ID: " + order.getOrderId());
        for (MenuItem item : order.getItems()) {
            System.out.println("- " + item.toString());
        }
        System.out.println("Total Due: $" + order.total());

        System.out.println("\n--- Processing Payment ---");
        PaymentMethod card = new CreditCardPayment("9876");
        PaymentReceipt receipt = card.pay(order.getOrderId(), order.total());

        System.out.println("Paid: $" + receipt.amount() + " via " + receipt.method());
        System.out.println("Timestamp: " + receipt.timestamp());
        System.out.println("Status: APPROVED");
    }
}