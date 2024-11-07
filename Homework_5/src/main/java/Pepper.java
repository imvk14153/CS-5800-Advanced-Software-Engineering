public class Pepper extends ToppingDecorator {
    private static final double COST = 0.49;

    public Pepper(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + COST;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " + Pepper";
    }
}