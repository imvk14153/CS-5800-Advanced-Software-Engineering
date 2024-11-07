public class Chicken extends ToppingDecorator {
    private static final double COST = 2.99;

    public Chicken(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + COST;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " + Chicken";
    }
}