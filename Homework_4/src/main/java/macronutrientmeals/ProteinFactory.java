package macronutrientmeals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProteinFactory {
    private static ProteinFactory instance;

    private ProteinFactory() {}

    public static ProteinFactory getInstance() {
        if (instance == null) {
            instance = new ProteinFactory();
        }
        return instance;
    }

    public Protein getProtein(DietPlan dietPlan) {
        List<Protein> allowedProteins = new ArrayList<>();
        for (Protein protein : Protein.values()) {
            if (dietPlan == DietPlan.Vegan && (protein == Protein.Fish || protein == Protein.Chicken)) continue;
            if (dietPlan == DietPlan.Paleo && protein == Protein.Tofu) continue;
            allowedProteins.add(protein);
        }
        return allowedProteins.get(new Random().nextInt(allowedProteins.size()));
    }
}
