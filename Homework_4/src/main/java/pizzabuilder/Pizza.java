package pizzabuilder;

import java.util.List;
import java.util.stream.Collectors;

public class Pizza {
    private String chainName;
    private String size;
    private List<String> toppings;

    public Pizza(String chainName, String size, List<String> toppings) {
        this.chainName = chainName;
        this.size = size;
        this.toppings = toppings;
    }

    public void eat() {
        String toppingsList = toppings.stream().collect(Collectors.joining(", "));
        System.out.println("Chain Name: " + chainName + "\nSize: " + size + "\nToppings: " + toppingsList + "\n");
    }

    public String getChainName() {
        return chainName;
    }

    public String getSize() {
        return size;
    }

    public List<String> getToppings() {
        return toppings;
    }
}