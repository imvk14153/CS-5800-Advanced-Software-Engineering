public class Burger implements FoodItem {
    private static final double BASE_PRICE = 6.99;

    @Override
    public double getCost() {
        return BASE_PRICE;
    }

    @Override
    public String getDescription() {
        return "Burger";
    }
}