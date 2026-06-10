package edu.norcocollege.cis18b.week3.coffeeshop;

public class ColdBrew extends Beverage {
    public ColdBrew(Size size) {
        super("COLD_BREW", "Cold Brew", PricingCatalog.getInstance().getBasePrice("COLD_BREW"), size);
    }
}