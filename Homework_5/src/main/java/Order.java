import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getCost();
        }
        return total;
    }

    public void displayOrder() {
        for (FoodItem item : items) {
            System.out.println(item.getDescription() + ": $" + item.getCost());
        }
        System.out.println("\nTotal Cost: $" + calculateTotalCost());
    }
}