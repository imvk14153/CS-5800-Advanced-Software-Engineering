package macronutrientmeals;

public class MacronutrientFactory {
    private static MacronutrientFactory instance;

    private MacronutrientFactory() {}

    public static MacronutrientFactory getInstance() {
        if (instance == null) {
            instance = new MacronutrientFactory();
        }
        return instance;
    }

    public Meal createMeal(DietPlan dietPlan) {
        Carbs carb = CarbsFactory.getInstance().getCarb(dietPlan);
        Protein protein = ProteinFactory.getInstance().getProtein(dietPlan);
        Fats fat = FatsFactory.getInstance().getFat(dietPlan);
        return new Meal(carb, protein, fat);
    }
}
