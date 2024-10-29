import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import macronutrientmeals.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MacronutrientMealsTest {

    // CarbsFactory Tests
    @Test
    void testGetCarbForNoRestriction() {
        Carbs carb = CarbsFactory.getInstance().getCarb(DietPlan.NoRestriction);
        assertNotNull(carb, "Carb is required for NoRestriction diet plan.");
    }

    @Test
    void testGetCarbForPaleo() {
        Carbs carb = CarbsFactory.getInstance().getCarb(DietPlan.Paleo);
        assertEquals(Carbs.Pistachio, carb, "Paleo diet can only have Pistachio as Carb.");
    }

    @Test
    void testGetCarbForNutAllergy() {
        Carbs carb = CarbsFactory.getInstance().getCarb(DietPlan.NutAllergy);
        assertNotEquals(Carbs.Pistachio, carb, "NutAllergy diet cannot have Pistachio as a Carb.");
    }

    @Test
    void testGetCarbForVegan() {
        Carbs carb = CarbsFactory.getInstance().getCarb(DietPlan.Vegan);
        assertNotEquals(Carbs.Cheese, carb, "Vegan diet cannot have Cheese as Carb.");
    }

    // ProteinFactory Tests
    @Test
    void testGetProteinForNoRestriction() {
        Protein protein = ProteinFactory.getInstance().getProtein(DietPlan.NoRestriction);
        assertNotNull(protein, "Protein is required for NoRestriction diet plan.");
    }

    @Test
    void testGetProteinForPaleo() {
        Protein protein = ProteinFactory.getInstance().getProtein(DietPlan.Paleo);
        assertNotEquals(Protein.Tofu, protein, "Paleo diet cannot have Tofu as Protein.");
    }

    @Test
    void testGetProteinForVegan() {
        Protein protein = ProteinFactory.getInstance().getProtein(DietPlan.Vegan);
        assertNotEquals(Protein.Fish, protein, "Vegan diet cannot have Fish as Protein.");
        assertNotEquals(Protein.Chicken, protein, "Vegan diet cannot have Chicken as Protein.");
    }

    // FatsFactory Tests
    @Test
    void testGetFatForNoRestriction() {
        Fats fat = FatsFactory.getInstance().getFat(DietPlan.NoRestriction);
        assertNotNull(fat, "Fat is required for NoRestriction diet plan.");
    }

    @Test
    void testGetFatForPaleo() {
        Fats fat = FatsFactory.getInstance().getFat(DietPlan.Paleo);
        assertNotEquals(Fats.SourCream, fat, "Paleo diet cannot have SourCream as Fat.");
    }

    @Test
    void testGetFatForVegan() {
        Fats fat = FatsFactory.getInstance().getFat(DietPlan.Vegan);
        assertNotEquals(Fats.SourCream, fat, "Vegan diet cannot have SourCream as Fat.");
        assertNotEquals(Fats.Tuna, fat, "Vegan diet cannot have Tuna as Fat.");
    }

    @Test
    void testGetFatForNutAllergy() {
        Fats fat = FatsFactory.getInstance().getFat(DietPlan.NutAllergy);
        assertNotEquals(Fats.Peanuts, fat, "NutAllergy diet cannot have Peanuts as Fat.");
    }

    // MacronutrientFactory Tests
    @Test
    void testCreateMealForNoRestriction() {
        Meal meal = MacronutrientFactory.getInstance().createMeal(DietPlan.NoRestriction);
        assertNotNull(meal, "Meal is required for NoRestriction diet plan.");
    }

    @Test
    void testCreateMealForPaleo() {
        Meal meal = MacronutrientFactory.getInstance().createMeal(DietPlan.Paleo);
        assertNotNull(meal, "Meal is required for Paleo diet plan.");
        assertNotEquals(Carbs.Cheese, meal.getCarb(), "Paleo diet cannot have Cheese as Carb.");
        assertNotEquals(Carbs.Bread, meal.getCarb(), "Paleo diet cannot have Bread as Carb.");
        assertNotEquals(Carbs.Lentils, meal.getCarb(), "Paleo diet cannot have Lentils as Carb.");
        assertNotEquals(Protein.Tofu, meal.getProtein(), "Paleo diet cannot have Tofu as Protein.");
        assertNotEquals(Fats.SourCream, meal.getFat(), "Paleo diet cannot have SourCream as Fat.");
    }

    @Test
    void testCreateMealForVegan() {
        Meal meal = MacronutrientFactory.getInstance().createMeal(DietPlan.Vegan);
        assertNotNull(meal, "Meal is required for Vegan diet plan.");
        assertNotEquals(Carbs.Cheese, meal.getCarb(), "Vegan diet cannot have Cheese as Carb.");
        assertNotEquals(Protein.Fish, meal.getProtein(), "Vegan diet cannot have Fish as Protein.");
        assertNotEquals(Protein.Chicken, meal.getProtein(), "Vegan diet cannot have Chicken as Protein.");
        assertNotEquals(Fats.SourCream, meal.getFat(), "Vegan diet cannot have SourCream as Fat.");
        assertNotEquals(Fats.Tuna, meal.getFat(), "Vegan diet cannot have Tuna as Fat.");
    }

    @Test
    void testCreateMealForNutAllergy() {
        Meal meal = MacronutrientFactory.getInstance().createMeal(DietPlan.NutAllergy);
        assertNotNull(meal, "Meal is required for NutAllergy diet plan.");
        assertNotEquals(Carbs.Pistachio, meal.getCarb(), "NutAllergy diet cannot have Pistachio as Carb.");
        assertNotEquals(Fats.Peanuts, meal.getFat(), "NutAllergy diet cannot have Peanuts as Fat.");
    }

    // Meal Tests
    @Test
    void testDisplayMeal() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Meal meal = new Meal(Carbs.Lentils, Protein.Tofu, Fats.SourCream);
        meal.displayMeal();

        System.setOut(System.out);

        String expectedOutput = "Macronutrients for the selected Diet Plan:\n" +
                "    Carb: Lentils\n" +
                "    Protein: Tofu\n" +
                "    Fat: SourCream";

        assertEquals(expectedOutput, outputStream.toString().trim());
    }
}
