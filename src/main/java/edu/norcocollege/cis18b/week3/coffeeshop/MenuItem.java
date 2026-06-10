package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class MenuItem {
    private String sku;
    private String name;
    private BigDecimal price;

    public MenuItem(String sku, String name, BigDecimal price) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be null or blank");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be null or negative");
        }
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " [" + sku + "] - $" + price;
    }
}