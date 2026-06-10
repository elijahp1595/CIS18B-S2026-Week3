package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class ColdBrew extends Beverage {
    public ColdBrew(String sku, String name, Size size) {
        super(sku, name, PricingCatalog.getInstance().getBasePrice("COLD_BREW"), size);
    }
}