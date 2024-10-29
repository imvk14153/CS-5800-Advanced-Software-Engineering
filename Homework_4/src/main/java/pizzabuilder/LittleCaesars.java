package pizzabuilder;

public class LittleCaesars {

    public static PizzaBuilder createPizza() {
        return new PizzaBuilder().setChainName("Little Caesars");
    }
}