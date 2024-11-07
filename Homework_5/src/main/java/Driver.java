public class Driver {
    public static void main(String[] args) {

        FoodItem burger = new Cheese(new Chicken(new Burger()));
        FoodItem fries = new Fries();
        FoodItem pizza = new Cheese(new Pesto(new Pizza()));
        FoodItem quesadilla = new ChipotleSauce(new Mayo(new Quesadilla()));
        FoodItem riceBowl = new Salt(new Pepper(new Chicken(new RiceBowl())));

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(pizza);
        order.addItem(quesadilla);
        order.addItem(riceBowl);

        System.out.println("CUSTOMER ORDER SUMMARY\n");
        order.displayOrder();

        LoyaltyStatus loyaltyStatus = new LoyaltyStatus(LoyaltyStatus.GOLD);
        System.out.println("\nCustomer Loyalty Status: " + loyaltyStatus.getLevel());
        System.out.println("Discount Applied: " + loyaltyStatus.getDiscountPercentage() + "%");

        double totalCostWithDiscount = loyaltyStatus.applyDiscount(order.calculateTotalCost());
        System.out.printf("Total Cost after Discount: $%.2f%n", totalCostWithDiscount);
    }
}