package macronutrientmeals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FatsFactory {
    private static FatsFactory instance;

    private FatsFactory() {}

    public static FatsFactory getInstance() {
        if (instance == null) {
            instance = new FatsFactory();
        }
        return instance;
    }

    public Fats getFat(DietPlan dietPlan) {
        List<Fats> allowedFats = new ArrayList<>();
        for (Fats fat : Fats.values()) {
            if (dietPlan == DietPlan.Paleo && fat == Fats.SourCream) continue;
            if (dietPlan == DietPlan.Vegan && (fat == Fats.SourCream || fat == Fats.Tuna)) continue;
            if (dietPlan == DietPlan.NutAllergy && fat == Fats.Peanuts) continue;
            allowedFats.add(fat);
        }
        return allowedFats.get(new Random().nextInt(allowedFats.size()));
    }
}
