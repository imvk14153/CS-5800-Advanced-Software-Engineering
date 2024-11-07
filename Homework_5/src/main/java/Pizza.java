public class Pizza implements FoodItem {
    private static final double BASE_PRICE = 11.99;

    @Override
    public double getCost() {
        return BASE_PRICE;
    }

    @Override
    public String getDescription() {
        return "Pizza";
    }
}