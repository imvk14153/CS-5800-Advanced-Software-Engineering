public abstract class ToppingDecorator implements FoodItem {
    protected FoodItem foodItem;

    public ToppingDecorator(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription();
    }
}