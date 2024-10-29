package pizzabuilder;

public class Driver {

    public static void main(String[] args) {
        // Pizza Hut small pizza with 3 toppings
        Pizza pizzaHutPizza1 = PizzaHut.createPizza()
                .setSizeSmall()
                .withChicken()
                .withMushrooms()
                .withOlives()
                .build();

        // Pizza Hut medium pizza with 6 toppings
        Pizza pizzaHutPizza2 = PizzaHut.createPizza()
                .setSizeMedium()
                .withChicken()
                .withExtraCheese()
                .withPeppers()
                .withTomatoAndBasil()
                .withOlives()
                .withSpinach()
                .build();

        // Pizza Hut large pizza with 9 toppings
        Pizza pizzaHutPizza3 = PizzaHut.createPizza()
                .setSizeLarge()
                .withChicken()
                .withSausage()
                .withMushrooms()
                .withBacon()
                .withSpicyPork()
                .withExtraCheese()
                .withPeppers()
                .withHamAndPineapple()
                .withOlives()
                .build();

        // Pizza Hut Pizzas
        // Pizza Hut large pizza with 3 toppings
        Pizza pizzaHutPizza4 = PizzaHut.createPizza()
                .setSizeLarge()
                .withChicken()
                .withHamAndPineapple()
                .withExtraCheese()
                .build();

        // Pizza Hut small pizza with 2 toppings
        Pizza pizzaHutPizza5 = PizzaHut.createPizza()
                .setSizeSmall()
                .withOlives()
                .withPeppers()
                .build();

        // Little Caesars Pizza
        // Little Caesars medium pizza with 8 toppings
        Pizza littleCaesarsPizza1 = LittleCaesars.createPizza()
                .setSizeMedium()
                .withChicken()
                .withOlives()
                .withMushrooms()
                .withBacon()
                .withSpinach()
                .withExtraCheese()
                .withPeppers()
                .withPesto()
                .build();

        // Little Caesars small pizza with 6 toppings
        Pizza littleCaesarsPizza2 = LittleCaesars.createPizza()
                .setSizeSmall()
                .withOlives()
                .withSpinach()
                .withTomatoAndBasil()
                .withChicken()
                .withHam()
                .withPesto()
                .build();

        // Dominos Pizzas
        // Dominos small pizza with 1 topping
        Pizza dominosPizza1 = Dominos.createPizza()
                .setSizeSmall()
                .withChicken()
                .build();

        // Dominos large pizza with 3 toppings
        Pizza dominosPizza2 = Dominos.createPizza()
                .setSizeLarge()
                .withChicken()
                .withPesto()
                .withTomatoAndBasil()
                .build();

        pizzaHutPizza1.eat();
        pizzaHutPizza2.eat();
        pizzaHutPizza3.eat();
        pizzaHutPizza4.eat();
        pizzaHutPizza5.eat();

        littleCaesarsPizza1.eat();
        littleCaesarsPizza2.eat();

        dominosPizza1.eat();
        dominosPizza2.eat();
    }
}