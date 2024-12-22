package Vol9Var11;

import java.io.*;
import java.util.*;
import java.util.Locale;

public class NumberProcessor {
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = -Double.MAX_VALUE;

    public static List<Double> readNumbersFromFile(String filePath) throws InvalidNumberException {
        List<Double> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    throw new InvalidNumberException("Неправильное форматирование.");
                }

                String numberPart = parts[0].trim();
                String localePart = parts[1].trim();

                try {
                    Locale locale = Locale.forLanguageTag(localePart);
                    double number = Double.parseDouble(numberPart.replace(',', '.'));
                    if (number < MIN_VALUE || number > MAX_VALUE) {
                        throw new InvalidNumberException("Числа вышли за предел: " + number);
                    }
                    numbers.add(number);
                } catch (NumberFormatException ex) {
                    throw new InvalidNumberException("Неправильные числа: " + numberPart);
                }
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Файл не найден: " + filePath, ex);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка чтения файла: " + filePath, ex);
        } catch (OutOfMemoryError ex) {
            throw new RuntimeException("Недостаточно памяти", ex);
        }

        return numbers;
    }

    public static double calculateSum(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

    public static double calculateAverage(List<Double> numbers) {
        return numbers.isEmpty() ? 0 : calculateSum(numbers) / numbers.size();
    }
}
