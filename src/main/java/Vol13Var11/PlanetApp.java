package Vol13Var11;// Импорт пакетов
import java.sql.*;

public class PlanetApp {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/PlanetDB", "sa", "")) {
            DatabaseInitializer.initializeDatabase(connection);

            DatabaseInitializer.insertSampleData(connection);

            System.out.println("Планеты с жизнью в указанной галактике:");
            Queries.getPlanetsWithLife(connection, "Млечный Путь").forEach(System.out::println);

            System.out.println("Планеты с наименьшим радиусом и наибольшим количеством спутников:");
            Queries.getPlanetsByRadiusAndMoons(connection).forEach(System.out::println);

            System.out.println("Планета с максимальным количеством спутников и наименьшим общим объёмом спутников:");
            System.out.println(Queries.getPlanetWithMaxMoonsAndMinMoonVolume(connection));

            System.out.println("Галактика с наибольшей суммой ядерных температур:");
            System.out.println(Queries.getGalaxyWithMaxCoreTempSum(connection));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

