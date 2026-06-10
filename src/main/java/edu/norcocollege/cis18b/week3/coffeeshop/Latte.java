package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class Latte extends Beverage {
    public Latte(String sku, String name, Size size) {
        super(sku, name, PricingCatalog.getInstance().getBasePrice("LATTE"), size);
    }
}