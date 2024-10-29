package macronutrientmeals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarbsFactory {
    private static CarbsFactory instance;

    private CarbsFactory() {}

    public static CarbsFactory getInstance() {
        if (instance == null) {
            instance = new CarbsFactory();
        }
        return instance;
    }

    public Carbs getCarb(DietPlan dietPlan) {
        List<Carbs> allowedCarbs = new ArrayList<>();
        for (Carbs carb : Carbs.values()) {
            if (dietPlan == DietPlan.Paleo && carb != Carbs.Pistachio) continue;
            if (dietPlan == DietPlan.NutAllergy && carb == Carbs.Pistachio) continue;
            if (dietPlan == DietPlan.Vegan && carb == Carbs.Cheese) continue;
            allowedCarbs.add(carb);
        }
        return allowedCarbs.get(new Random().nextInt(allowedCarbs.size()));
    }
}
