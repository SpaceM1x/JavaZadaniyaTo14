package Vol4Var11.VariantB;

public abstract class Insurance {
    private String name;
    private double cost;
    private int riskLevel;

    public Insurance(String name, double cost, int riskLevel) {
        this.name = name;
        this.cost = cost;
        this.riskLevel = riskLevel;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    @Override
    public String toString() {
        return "Страховка: Имя ='" + name + "', Цена =" + cost + ", Уровень Риска =" + riskLevel + "}";
    }
}
