public class Cheese extends ToppingDecorator {
    private static final double COST = 1.99;

    public Cheese(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + COST;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " + Cheese";
    }
}