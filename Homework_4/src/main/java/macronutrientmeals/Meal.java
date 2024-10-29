package macronutrientmeals;

public class Meal {
    private final Carbs carb;
    private final Protein protein;
    private final Fats fat;

    public Meal(Carbs carb, Protein protein, Fats fat) {
        this.carb = carb;
        this.protein = protein;
        this.fat = fat;
    }

    public Carbs getCarb() {
        return carb;
    }

    public Protein getProtein() {
        return protein;
    }

    public Fats getFat() {
        return fat;
    }

    public void displayMeal() {
        System.out.print("Macronutrients for the selected Diet Plan:\n");
        System.out.print("    Carb: " + carb + "\n");
        System.out.print("    Protein: " + protein + "\n");
        System.out.print("    Fat: " + fat);
    }
}
