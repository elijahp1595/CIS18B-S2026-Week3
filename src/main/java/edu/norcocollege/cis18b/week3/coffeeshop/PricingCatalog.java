package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PricingCatalog {
    private static PricingCatalog instance;
    private Map<String, BigDecimal> prices;

    private PricingCatalog() {
        prices = new HashMap<>();
        prices.put("LATTE", new BigDecimal("4.50"));
        prices.put("COLD_BREW", new BigDecimal("4.00"));
        prices.put("CUSTOM", new BigDecimal("4.25"));
    }

    public static PricingCatalog getInstance() {
        if (instance == null) {
            instance = new PricingCatalog();
        }
        return instance;
    }

    public BigDecimal getBasePrice(String productKey) {
        if (productKey == null || !prices.containsKey(productKey)) {
            throw new IllegalArgumentException("Unknown product key");
        }
        return prices.get(productKey);
    }
}