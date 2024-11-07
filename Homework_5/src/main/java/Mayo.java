public class Mayo extends ToppingDecorator {
    private static final double COST = 1.49;

    public Mayo(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + COST;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " + Mayo";
    }
}