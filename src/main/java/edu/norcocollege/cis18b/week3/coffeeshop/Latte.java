package edu.norcocollege.cis18b.week3.coffeeshop;

public class Latte extends Beverage {
    public Latte(Size size) {
        super("LATTE", "Latte", PricingCatalog.getInstance().getBasePrice("LATTE"), size);
    }
}