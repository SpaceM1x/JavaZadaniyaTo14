package Vol9Var11;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/Vol9Var11/Numbers.txt";

        try {
            List<Double> numbers = NumberProcessor.readNumbersFromFile(filePath);

            double sum = NumberProcessor.calculateSum(numbers);
            double average = NumberProcessor.calculateAverage(numbers);

            System.out.println("Числа: " + numbers);
            System.out.println("Сумма: " + sum);
            System.out.println("Среднее: " + average);
        } catch (InvalidNumberException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Ошибка Runtime: " + e.getMessage());
        }
    }
}
