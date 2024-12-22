package Vol4Var11.VariantA;

public class Hen extends Bird {
    @Override
    public void fly() {
        System.out.println("Наседка не может улететь далеко.");
    }

    @Override
    public void sing() {
        System.out.println("Наседка кудахчет.");
    }

    public void layEggs() {
        System.out.println("Наседка откладывает яйца.");
    }

    public void broodChicks() {
        System.out.println("Наседка выгуливает цыплят.");
    }
}