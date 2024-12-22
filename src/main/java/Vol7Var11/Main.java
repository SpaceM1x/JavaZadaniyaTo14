package Vol7Var11;

public class Main {
    public static void main(String[] args) {

        String input = "This is a test of the StringProcessor class";
        int n = 2;
        int m = 4;
        int l = 50;


        String result = StringProcessor.processString(input, n, m, l);

        System.out.println("Обработаннаая строка: " + result);

    }
}
