package pizzabuilder;

public class PizzaHut {

    public static PizzaBuilder createPizza() {
        return new PizzaBuilder().setChainName("Pizza Hut");
    }
}