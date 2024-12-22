package Vol8Var11;

public class Main {
    public static void main(String[] args) {
        String sentence = "This is a simple example.";
        String result = TextProcessor.analyzeSentence(sentence);
        System.out.println("Результат: " + result);

        String sentence2 = "Hello <this is a test> world";
        char start = '<';
        char end = '>';
        String result2 = SubstringProcessor.removeLongestSubstring(sentence2, start, end);
        System.out.println("Обработанное сообщение: " + result2);

        String text = "This is an example programming test";
        String hyphenatedText = HyphenationProcessor.hyphenateText(text);
        System.out.println("Текст по слогам: " + hyphenatedText);
    }
}
