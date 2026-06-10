package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomDrink extends Beverage {

    public enum Milk {WHOLE, OAT, ALMOND, SKIM}
    public enum Syrup {VANILLA, CARAMEL, HAZELNUT, NONE}
    public enum Temperature {HOT, ICED}

    private CustomDrink(Builder builder) {
        // Fixed the lowercase 'builder' variable here
        super(builder.sku, builder.name, calculateBasePrice(builder), builder.size);
    }

    private static BigDecimal calculateBasePrice(Builder builder) {
        BigDecimal base = PricingCatalog.getInstance().getBasePrice("CUSTOM");

        if (builder.espressoShots > 1) {
            BigDecimal extraShotsPrice = new BigDecimal("0.75").multiply(new BigDecimal(builder.espressoShots - 1));
            base = base.add(extraShotsPrice);
        }

        if (builder.syrup != Syrup.NONE) {
            base = base.add(new BigDecimal("0.50"));
        }

        if (!builder.extras.isEmpty()) {
            BigDecimal extrasPrice = new BigDecimal("0.25").multiply(new BigDecimal(builder.extras.size()));
            base = base.add(extrasPrice);
        }

        return base;
    }

    public static class Builder {
        private String sku;
        private String name;
        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE; // Fixed MILK to Milk
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;
        private List<String> extras = new ArrayList<>();

        public Builder(String sku, String name) {
            this.sku = sku;
            this.name = name;
        }

        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Builder milk(Milk milk) {
            this.milk = milk;
            return this;
        }

        public Builder syrup(Syrup syrup) {
            this.syrup = syrup;
            return this;
        }

        public Builder temperature(Temperature temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder espressoShots(int shots) {
            if (shots < 1) {
                throw new IllegalArgumentException("espressoShots must be >= 1");
            }
            this.espressoShots = shots;
            return this;
        }

        public Builder addExtra(String extra) {
            if (extra == null || extra.trim().isEmpty()) {
                throw new IllegalArgumentException("extra cannot be null or blank");
            }
            this.extras.add(extra);
            return this;
        }
        
        public CustomDrink build() {
            return new CustomDrink(this);
        }
    }
}