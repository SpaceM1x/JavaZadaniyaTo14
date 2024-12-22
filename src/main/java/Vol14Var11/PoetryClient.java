package Vol14Var11;

import java.io.*;
import java.net.*;

public class PoetryClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Подключение к серверу: " + SERVER_HOST);

            StringBuilder poem = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                poem.append(line).append("\n");
            }

            System.out.println("Полученный стих:\n" + poem);

        } catch (IOException e) {
            System.err.println("Ошибка с клиентом: " + e.getMessage());
        }
    }
}
