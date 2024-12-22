package Vol4Var11.VariantB;

import java.util.ArrayList;
import java.util.List;

public class Derivative {
    private final List<Insurance> obligations = new ArrayList<>();

    public void addInsurance(Insurance insurance) {
        obligations.add(insurance);
    }

    public double calculateTotalCost() {
        return obligations.stream().mapToDouble(Insurance::getCost).sum();
    }

    public void sortByRisk() {
        obligations.sort((o1, o2) -> Integer.compare(o2.getRiskLevel(), o1.getRiskLevel()));
    }

    public List<Insurance> findByCostRange(double minCost, double maxCost) {
        List<Insurance> result = new ArrayList<>();
        for (Insurance insurance : obligations) {
            if (insurance.getCost() >= minCost && insurance.getCost() <= maxCost) {
                result.add(insurance);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return obligations.toString();
    }
}
