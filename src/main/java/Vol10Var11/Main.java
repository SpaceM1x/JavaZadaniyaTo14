package Vol10Var11;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗадание 1\n");
        runTask1();

        System.out.println("\nЗадание 2\n");
        runTask2();

        System.out.println("\nЗадание 3\n");
        runTask3();
    }

    private static void runTask1() {
        String inputFile = "src/main/java/Vol10Var11/inputTask1.txt";
        String outputFile = "outputTask1";

        try {
            VowelWordsFinder.processFile(inputFile, outputFile);
            System.out.println("Результат сохранён в файл: " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка обработки файла: " + e.getMessage());
        }
    }

    private static void runTask2() {
        String filePath = "insuranceData";
        InsuranceConnector connector = new InsuranceConnector(filePath);

        try {

            List<Insurance> insurances = List.of(
                    new Insurance("Страховние жизни", 1000.0, 5),
                    new Insurance("Страховка здоровья", 2000.0, 3),
                    new Insurance("Страховка на имущество", 1500.0, 7)
            );


            connector.saveInsurance(insurances);
            List<Insurance> loadedInsurances = connector.loadInsurance();


            System.out.println("Загруженные обязательства:");
            loadedInsurances.forEach(System.out::println);

            List<Insurance> sortedInsurances = connector.sortByRisk(loadedInsurances);
            System.out.println("Обязательства, отсортированные по убыванию риска:");
            sortedInsurances.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка работы с файлами: " + e.getMessage());
        }
    }

    private static void runTask3() {
        String inputFile = "src/main/java/Vol10Var11/inputTask3.txt";
        String outputDir = "outputTask3";
        int n = 5;
        int m = 3;

        try {
            LastWordsExtractor.extractLastWords(inputFile, outputDir, n, m);
            System.out.println("Результат сохранён в директории: " + outputDir);
        } catch (IOException e) {
            System.err.println("Ошибка обработки файла: " + e.getMessage());
        }
    }
}
