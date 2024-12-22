package Vol13Var11Test;

import Vol13Var11.DatabaseInitializer;
import Vol13Var11.Queries;
import org.junit.jupiter.api.*;
import java.sql.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlanetAppTests {

    private static Connection connection;

    @BeforeAll
    public static void setupDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:~/PlanetDB", "sa", "");
        DatabaseInitializer.initializeDatabase(connection);
        DatabaseInitializer.insertSampleData(connection);
    }

    @AfterAll
    public static void closeDatabase() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testGetPlanetsWithLife() throws SQLException {
        List<String> planetsWithLife = Queries.getPlanetsWithLife(connection, "Млечный Путь");
        assertNotNull(planetsWithLife, "Список планет не должен быть null");
        assertTrue(planetsWithLife.contains("Земля"), "Список должен содержать планету Земля");
    }

    @Test
    public void testGetPlanetsByRadiusAndMoons() throws SQLException {
        List<String> planets = Queries.getPlanetsByRadiusAndMoons(connection);
        assertNotNull(planets, "Список планет не должен быть null");
        assertEquals("Земля", planets.get(0), "Первой в списке должна быть Земля");
    }

    @Test
    public void testGetPlanetWithMaxMoonsAndMinMoonVolume() throws SQLException {
        String planet = Queries.getPlanetWithMaxMoonsAndMinMoonVolume(connection);
        assertNotNull(planet, "Имя планеты не должно быть null");
        assertEquals("Земля", planet, "Планетой с максимальным количеством спутников должна быть Земля");
    }

    @Test
    public void testGetGalaxyWithMaxCoreTempSum() throws SQLException {
        String galaxy = Queries.getGalaxyWithMaxCoreTempSum(connection);
        assertNotNull(galaxy, "Имя галактики не должно быть null");
        assertEquals("Млечный Путь", galaxy, "Галактикой с максимальной суммой температур должна быть Млечный Путь");
    }
}
