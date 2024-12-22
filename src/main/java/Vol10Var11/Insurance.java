package Vol10Var11;

import java.io.*;
import java.util.*;

public class Insurance implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double cost;
    private int risk;

    public Insurance(String name, double cost, int risk) {
        this.name = name;
        this.cost = cost;
        this.risk = risk;
    }

    public double getCost() {
        return cost;
    }

    public int getRisk() {
        return risk;
    }

    @Override
    public String toString() {

        return "Страховка {Имя='" + name + "', Цена=" + cost + ", Риск=" + risk + "}";

    }
}

