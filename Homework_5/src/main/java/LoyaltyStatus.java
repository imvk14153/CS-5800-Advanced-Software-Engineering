public class LoyaltyStatus {
    public static final String SILVER = "Silver";
    public static final String GOLD = "Gold";
    public static final String PLATINUM = "Platinum";

    private String level;

    public LoyaltyStatus(String level) {
        this.level = level;
    }

    public double applyDiscount(double totalCost) {
        double discountPercentage = getDiscountPercentage();
        return totalCost - (totalCost * (discountPercentage / 100));
    }

    public double getDiscountPercentage() {
        return switch (level) {
            case SILVER -> 5;
            case GOLD -> 10;
            case PLATINUM -> 20;
            default -> 0;
        };
    }

    public String getLevel() {
        return level;
    }
}