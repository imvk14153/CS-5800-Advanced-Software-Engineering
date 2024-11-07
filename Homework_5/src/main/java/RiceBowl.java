public class RiceBowl implements FoodItem {
    private static final double BASE_PRICE = 8.99;

    @Override
    public double getCost() {
        return BASE_PRICE;
    }

    @Override
    public String getDescription() {
        return "Rice Bowl";
    }
}