package Vol14Var11;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class PoetryServer {
    private static final int PORT = 12345;
    private static final String POEMS_FILE = "src/main/java/Vol14Var11/poems.txt";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Клиент подключен: " + clientSocket.getInetAddress());

                    String poem = getRandomPoem();
                    out.println(poem);

                } catch (IOException e) {
                    System.err.println("Ошибка с клиентом: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка сервера: " + e.getMessage());
        }
    }

    private static String getRandomPoem() throws IOException {
        String content = Files.readString(Paths.get(POEMS_FILE));
        String[] poems = content.split("---");
        if (poems.length == 0) {
            throw new IOException("Файл с поэмами пуст или некорректен.");
        }
        Random random = new Random();
        int index = random.nextInt(poems.length);
        return poems[index].trim();
    }
}
