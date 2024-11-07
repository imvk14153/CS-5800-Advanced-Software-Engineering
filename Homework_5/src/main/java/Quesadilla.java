public class Quesadilla implements FoodItem {
    private static final double BASE_PRICE = 7.99;

    @Override
    public double getCost() {
        return BASE_PRICE;
    }

    @Override
    public String getDescription() {
        return "Quesadilla";
    }
}