public class Fries implements FoodItem {
    private static final double BASE_PRICE = 3.99;

    @Override
    public double getCost() {
        return BASE_PRICE;
    }

    @Override
    public String getDescription() {
        return "Fries";
    }
}