package pizzabuilder;

public class Dominos {

    public static PizzaBuilder createPizza() {
        return new PizzaBuilder().setChainName("Dominos");
    }
}