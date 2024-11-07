public class Pesto extends ToppingDecorator {
    private static final double COST = 0.99;

    public Pesto(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + COST;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " + Pesto";
    }
}