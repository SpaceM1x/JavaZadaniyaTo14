package Vol13Var11;

import java.sql.*;

public class DatabaseInitializer {
    public static void initializeDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Galaxy (id IDENTITY PRIMARY KEY, name VARCHAR(255));");
            statement.execute("CREATE TABLE IF NOT EXISTS Planet (id IDENTITY PRIMARY KEY, name VARCHAR(255), radius DOUBLE, coreTemperature DOUBLE, hasAtmosphere BOOLEAN, hasLife BOOLEAN, galaxy_id BIGINT, FOREIGN KEY (galaxy_id) REFERENCES Galaxy(id));");
            statement.execute("CREATE TABLE IF NOT EXISTS Moon (id IDENTITY PRIMARY KEY, name VARCHAR(255), radius DOUBLE, distanceFromPlanet DOUBLE, planet_id BIGINT, FOREIGN KEY (planet_id) REFERENCES Planet(id));");
        }
    }

    public static void insertSampleData(Connection connection) throws SQLException {
        try (PreparedStatement insertGalaxy = connection.prepareStatement("INSERT INTO Galaxy (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
             PreparedStatement insertPlanet = connection.prepareStatement("INSERT INTO Planet (name, radius, coreTemperature, hasAtmosphere, hasLife, galaxy_id) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
             PreparedStatement insertMoon = connection.prepareStatement("INSERT INTO Moon (name, radius, distanceFromPlanet, planet_id) VALUES (?, ?, ?, ?)");) {

            insertGalaxy.setString(1, "Млечный Путь");
            insertGalaxy.executeUpdate();
            ResultSet galaxyKeys = insertGalaxy.getGeneratedKeys();
            galaxyKeys.next();
            long galaxyId = galaxyKeys.getLong(1);

            insertPlanet.setString(1, "Земля");
            insertPlanet.setDouble(2, 6371);
            insertPlanet.setDouble(3, 6000);
            insertPlanet.setBoolean(4, true);
            insertPlanet.setBoolean(5, true);
            insertPlanet.setLong(6, galaxyId);
            insertPlanet.executeUpdate();
            ResultSet planetKeys = insertPlanet.getGeneratedKeys();
            planetKeys.next();
            long planetId = planetKeys.getLong(1);

            insertMoon.setString(1, "Луна");
            insertMoon.setDouble(2, 1737);
            insertMoon.setDouble(3, 384400);
            insertMoon.setLong(4, planetId);
            insertMoon.executeUpdate();
        }
    }
}
