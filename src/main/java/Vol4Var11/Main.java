package Vol4Var11;
import Vol4Var11.VariantA.Bird;
import Vol4Var11.VariantA.Hen;
import Vol4Var11.VariantA.Sparrow;
import Vol4Var11.VariantB.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        //1 задание:

        Bird sparrow = new Sparrow();
        Bird hen = new Hen();

        sparrow.fly();
        sparrow.sing();

        hen.fly();
        hen.sing();
        ((Hen) hen).layEggs();
        ((Hen) hen).broodChicks();


        //2 задание:

        Derivative derivative = new Derivative();

        derivative.addInsurance(new HealthInsurance("Защита Здоровья План А", 500.0, 5));
        derivative.addInsurance(new CarInsurance("Страховка на автомобиль", 1200.0, 8));
        derivative.addInsurance(new PropertyInsurance("Страховка Дома", 800.0, 6));

        System.out.println("Итоговая сумма: " + derivative.calculateTotalCost());

        derivative.sortByRisk();
        System.out.println("Сортировка по рискам: " + derivative);

        List<Insurance> filtered = derivative.findByCostRange(600, 1300);
        System.out.println("Поиск в диапазоне цен: " + filtered);
    }
}