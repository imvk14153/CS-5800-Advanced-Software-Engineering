package pizzabuilder;
import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private String chainName;
    private String size;
    private List<String> toppings = new ArrayList<>();

    public PizzaBuilder setChainName(String chainName) {
        this.chainName = chainName;
        return this;
    }

    public PizzaBuilder setSizeSmall() {
        this.size = "Small";
        return this;
    }

    public PizzaBuilder setSizeMedium() {
        this.size = "Medium";
        return this;
    }

    public PizzaBuilder setSizeLarge() {
        this.size = "Large";
        return this;
    }

    public PizzaBuilder withPepperoni() {
        this.toppings.add("Pepperoni");
        return this;
    }

    public PizzaBuilder withSausage() {
        this.toppings.add("Sausage");
        return this;
    }

    public PizzaBuilder withMushrooms() {
        this.toppings.add("Mushrooms");
        return this;
    }

    public PizzaBuilder withBacon() {
        this.toppings.add("Bacon");
        return this;
    }

    public PizzaBuilder withOnions() {
        this.toppings.add("Onions");
        return this;
    }

    public PizzaBuilder withExtraCheese() {
        this.toppings.add("Extra Cheese");
        return this;
    }

    public PizzaBuilder withPeppers() {
        this.toppings.add("Peppers");
        return this;
    }

    public PizzaBuilder withChicken() {
        this.toppings.add("Chicken");
        return this;
    }

    public PizzaBuilder withOlives() {
        this.toppings.add("Olives");
        return this;
    }

    public PizzaBuilder withSpinach() {
        this.toppings.add("Spinach");
        return this;
    }

    public PizzaBuilder withTomatoAndBasil() {
        this.toppings.add("Tomato and Basil");
        return this;
    }

    public PizzaBuilder withBeef() {
        this.toppings.add("Beef");
        return this;
    }

    public PizzaBuilder withHam() {
        this.toppings.add("Ham");
        return this;
    }

    public PizzaBuilder withPesto() {
        this.toppings.add("Pesto");
        return this;
    }

    public PizzaBuilder withSpicyPork() {
        this.toppings.add("Spicy Pork");
        return this;
    }

    public PizzaBuilder withHamAndPineapple() {
        this.toppings.add("Ham and Pineapple");
        return this;
    }

    public Pizza build() {
        if (size == null) {
            throw new IllegalStateException("Pizza size is required!");
        }
        return new Pizza(chainName, size, toppings);
    }
}
