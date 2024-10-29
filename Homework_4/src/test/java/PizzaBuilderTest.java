import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pizzabuilder.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class PizzaBuilderTest {

    // Chain Name Tests
    @Test
    public void testSetChainNamePizzaHut() {
        Pizza pizza = PizzaHut.createPizza()
                .setSizeSmall()
                .build();
        assertEquals("Pizza Hut", pizza.getChainName());
    }

    @Test
    public void testSetChainNameLittleCaesars() {
        Pizza pizza = LittleCaesars.createPizza()
                .setSizeMedium()
                .build();
        assertEquals("Little Caesars", pizza.getChainName());
    }

    @Test
    public void testSetChainNameDominos() {
        Pizza pizza = Dominos.createPizza()
                .setSizeLarge()
                .build();
        assertEquals("Dominos", pizza.getChainName());
    }

    // Size Tests
    @Test
    public void testSetSizeSmall() {
        Pizza pizza = Dominos.createPizza()
                .setSizeSmall()
                .build();
        assertEquals("Small", pizza.getSize());
    }

    @Test
    public void testSetSizeMedium() {
        Pizza pizza = LittleCaesars.createPizza()
                .setSizeMedium()
                .build();
        assertEquals("Medium", pizza.getSize());
    }

    @Test
    public void testSetSizeLarge() {
        Pizza pizza = PizzaHut.createPizza()
                .setSizeLarge()
                .build();
        assertEquals("Large", pizza.getSize());
    }

    // Individual Topping Tests
    @Test
    public void testWithPepperoni() {
        Pizza pizza = PizzaHut.createPizza()
                .setSizeLarge()
                .withPepperoni()
                .build();
        assertTrue(pizza.getToppings().contains("Pepperoni"));
    }

    @Test
    public void testWithSausage() {
        Pizza pizza = LittleCaesars.createPizza()
                .setSizeLarge()
                .withSausage()
                .build();
        assertTrue(pizza.getToppings().contains("Sausage"));
    }

    @Test
    public void testWithMushrooms() {
        Pizza pizza = Dominos.createPizza()
                .setSizeLarge()
                .withMushrooms()
                .build();
        assertTrue(pizza.getToppings().contains("Mushrooms"));
    }

    @Test
    public void testWithBacon() {
        Pizza pizza = PizzaHut.createPizza()
                .setSizeLarge()
                .withBacon()
                .build();
        assertTrue(pizza.getToppings().contains("Bacon"));
    }

    @Test
    public void testWithOnions() {
        Pizza pizza = LittleCaesars.createPizza()
                .setSizeLarge()
                .withOnions()
                .build();
        assertTrue(pizza.getToppings().contains("Onions"));
    }

    @Test
    public void testWithExtraCheese() {
        Pizza pizza = Dominos.createPizza()
                .setSizeLarge()
                .withExtraCheese()
                .build();
        assertTrue(pizza.getToppings().contains("Extra Cheese"));
    }

    @Test
    public void testWithPeppers() {
        Pizza pizza = PizzaHut.createPizza()
                .setSizeLarge()
                .withPeppers()
                .build();
        assertTrue(pizza.getToppings().contains("Peppers"));
    }

    @Test
    public void testWithChicken() {
        Pizza pizza = LittleCaesars.createPizza()
                .setSizeLarge()
                .withChicken()
                .build();
        assertTrue(pizza.getToppings().contains("Chicken"));
    }

    @Test
    public void testWithOlives() {
        Pizza pizza = Dominos.createPizza()
                .setSizeLarge()
                .withOlives()
                .build();
        assertTrue(pizza.getToppings().contains("Olives"));
    }

    @Test
    public void testWithSpinach() {
        Pizza pizza = PizzaHut.createPizza()
                .setSizeLarge()
                .withSpinach()
                .build();
        assertTrue(pizza.getToppings().contains("Spinach"));
    }

    @Test
    public void testWithTomatoAndBasil() {
        Pizza pizza = LittleCaesars.createPizza()
                .setSizeLarge()
                .withTomatoAndBasil()
                .build();
        assertTrue(pizza.getToppings().contains("Tomato and Basil"));
    }

    @Test
    public void testWithBeef() {
        Pizza pizza = Dominos.createPizza()
                .setSizeLarge()
                .withBeef()
                .build();
        assertTrue(pizza.getToppings().contains("Beef"));
    }

    @Test
    public void testWithHam() {
        Pizza pizza = PizzaHut.createPizza()
                .setSizeLarge()
                .withHam()
                .build();
        assertTrue(pizza.getToppings().contains("Ham"));
    }

    @Test
    public void testWithPesto() {
        Pizza pizza = LittleCaesars.createPizza()
                .setSizeLarge()
                .withPesto()
                .build();
        assertTrue(pizza.getToppings().contains("Pesto"));
    }

    @Test
    public void testWithSpicyPork() {
        Pizza pizza = Dominos.createPizza()
                .setSizeLarge()
                .withSpicyPork()
                .build();
        assertTrue(pizza.getToppings().contains("Spicy Pork"));
    }

    @Test
    public void testWithHamAndPineapple() {
        Pizza pizza = PizzaHut.createPizza()
                .setSizeLarge()
                .withHamAndPineapple()
                .build();
        assertTrue(pizza.getToppings().contains("Ham and Pineapple"));
    }

    // Multiple Toppings Test
    @Test
    public void testWithMultipleToppings() {
        Pizza pizza = Dominos.createPizza()
                .setSizeLarge()
                .withChicken()
                .withOlives()
                .withMushrooms()
                .withPeppers()
                .withExtraCheese()
                .build();
        assertEquals(Arrays.asList("Chicken", "Olives", "Mushrooms", "Peppers", "Extra Cheese"), pizza.getToppings());
    }

    // Test for Missing Size in build()
    @Test
    public void testBuildWithoutSizeThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            PizzaHut.createPizza()
                    .withChicken()
                    .build();
        });
        assertEquals("Pizza size is required!", exception.getMessage());
    }

    // eat() Method Output Test
    @Test
    public void testEatMethodOutput() {
        Pizza pizza = Dominos.createPizza()
                .setSizeMedium()
                .withChicken()
                .withOlives()
                .build();

        ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        pizza.eat();

        String expectedOutput = "Chain Name: Dominos\nSize: Medium\nToppings: Chicken, Olives";
        assertEquals(expectedOutput, outputStream.toString().trim());

        System.setOut(System.out);
    }
}