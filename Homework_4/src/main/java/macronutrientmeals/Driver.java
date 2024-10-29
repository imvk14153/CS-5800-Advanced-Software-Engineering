package macronutrientmeals;

public class Driver {
    public static void main(String[] args) {
        MacronutrientFactory macronutrientFactory = MacronutrientFactory.getInstance();

        Customer[] customers = {
                new Customer("Vikram", DietPlan.NoRestriction),
                new Customer("Swetha", DietPlan.NoRestriction),
                new Customer("Divya", DietPlan.Vegan),
                new Customer("Nishmitha", DietPlan.Paleo),
                new Customer("Bhargava", DietPlan.Vegan),
                new Customer("Bubble", DietPlan.NutAllergy)
        };

        for (Customer customer : customers) {
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Diet Plan: " + customer.getDietPlan());

            Meal meal = macronutrientFactory.createMeal(customer.getDietPlan());
            meal.displayMeal();
            System.out.println();
        }
    }
}
