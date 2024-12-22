package Vol11Var11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗадание 1\n");
        runTask1();

        System.out.println("\nЗадание 2\n");
        runTask2();
    }

    private static void runTask1() {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -3, 8, 1, -4, 7));

        System.out.println("Изначальный список: " + list);
        ListReorganizer.reorganize(list);
        System.out.println("Список после перестановки: " + list);
    }

    private static void runTask2() {

        String original = "HELLO WORLD";
        String encrypted = "KHOOR ZRUOG";

        System.out.println("Исходная строка: " + original);
        System.out.println("Зашифрованная строка: " + encrypted);

        System.out.println("Ищем ключи...");
        long startTime = System.currentTimeMillis();

        int[] keys = DoubleEncryption.findKeys(original, encrypted);

        long endTime = System.currentTimeMillis();
        System.out.println("Ключи найдены:");
        System.out.println("K1 = " + keys[0]);
        System.out.println("K2 = " + keys[1]);
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
    }
}
