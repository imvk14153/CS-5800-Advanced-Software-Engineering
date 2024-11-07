import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

    private FoodItem burger;
    private FoodItem fries;
    private FoodItem pizza;
    private FoodItem quesadilla;
    private FoodItem riceBowl;
    private LoyaltyStatus loyaltyStatus;

    @BeforeEach
    public void setUp() {
        // Basic food items setup for tests
        burger = new Burger();
        fries = new Fries();
        pizza = new Pizza();
        quesadilla = new Quesadilla();
        riceBowl = new RiceBowl();

        loyaltyStatus = new LoyaltyStatus(LoyaltyStatus.GOLD);
    }

    // Test for basic food items without toppings
    @Test
    public void testBasicFoodItems() {
        assertEquals(6.99, burger.getCost());
        assertEquals("Burger", burger.getDescription());

        assertEquals(3.99, fries.getCost());
        assertEquals("Fries", fries.getDescription());

        assertEquals(11.99, pizza.getCost());
        assertEquals("Pizza", pizza.getDescription());

        assertEquals(7.99, quesadilla.getCost());
        assertEquals("Quesadilla", quesadilla.getDescription());

        assertEquals(8.99, riceBowl.getCost());
        assertEquals("Rice Bowl", riceBowl.getDescription());
    }

    // Test for food items with toppings
    @Test
    public void testBurgerWithToppings() {
        burger = new Cheese(new Chicken(burger));
        assertEquals(6.99 + 1.99 + 2.99, burger.getCost());
        assertEquals("Burger + Chicken + Cheese", burger.getDescription());
    }

    @Test
    public void testPizzaWithToppings() {
        pizza = new Pesto(new Cheese(pizza));
        assertEquals(11.99 + 0.99 + 1.99, pizza.getCost());
        assertEquals("Pizza + Cheese + Pesto", pizza.getDescription());
    }

    @Test
    public void testRiceBowlWithMultipleToppings() {
        riceBowl = new Salt(new Pepper(new Chicken(riceBowl)));
        assertEquals(8.99 + 0.49 + 0.49 + 2.99, riceBowl.getCost());
        assertEquals("Rice Bowl + Chicken + Pepper + Salt", riceBowl.getDescription());
    }

    @Test
    public void testQuesadillaWithToppings() {
        quesadilla = new Mayo(new ChipotleSauce(quesadilla));
        assertEquals(7.99 + 1.49 + 0.99, quesadilla.getCost());
        assertEquals("Quesadilla + Chipotle Sauce + Mayo", quesadilla.getDescription());
    }

    // Test for Order class
    @Test
    public void testOrderTotalWithoutToppings() {
        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(pizza);

        double expectedTotal = burger.getCost() + fries.getCost() + pizza.getCost();
        assertEquals(expectedTotal, order.calculateTotalCost());
    }

    @Test
    public void testOrderTotalWithToppings() {
        burger = new Cheese(new Chicken(burger));
        pizza = new Cheese(new Pesto(pizza));

        Order order = new Order();
        order.addItem(burger);
        order.addItem(pizza);

        double expectedTotal = burger.getCost() + pizza.getCost();
        assertEquals(expectedTotal, order.calculateTotalCost());
    }

    // Test for LoyaltyStatus
    @Test
    public void testLoyaltyStatusDiscountGold() {
        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);

        double totalCost = order.calculateTotalCost();
        double expectedDiscountedTotal = totalCost - (totalCost * 0.10); // Gold = 10%

        assertEquals(expectedDiscountedTotal, loyaltyStatus.applyDiscount(totalCost));
    }

    @Test
    public void testLoyaltyStatusDiscountSilver() {
        loyaltyStatus = new LoyaltyStatus(LoyaltyStatus.SILVER);

        Order order = new Order();
        order.addItem(pizza);
        order.addItem(riceBowl);

        double totalCost = order.calculateTotalCost();
        double expectedDiscountedTotal = totalCost - (totalCost * 0.05); // Silver = 5%

        assertEquals(expectedDiscountedTotal, loyaltyStatus.applyDiscount(totalCost));
    }

    @Test
    public void testLoyaltyStatusDiscountPlatinum() {
        loyaltyStatus = new LoyaltyStatus(LoyaltyStatus.PLATINUM);

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(pizza);

        double totalCost = order.calculateTotalCost();
        double expectedDiscountedTotal = totalCost - (totalCost * 0.20); // Platinum = 20%

        assertEquals(expectedDiscountedTotal, loyaltyStatus.applyDiscount(totalCost));
    }

    // Test for no discount if no loyalty status
    @Test
    public void testLoyaltyStatusNoDiscount() {
        loyaltyStatus = new LoyaltyStatus("None");

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);

        double totalCost = order.calculateTotalCost();
        assertEquals(totalCost, loyaltyStatus.applyDiscount(totalCost));
    }
}