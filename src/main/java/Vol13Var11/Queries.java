package Vol13Var11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Queries {
    public static List<String> getPlanetsWithLife(Connection connection, String galaxyName) throws SQLException {
        List<String> results = new ArrayList<>();
        String query = "SELECT p.name FROM Planet p JOIN Galaxy g ON p.galaxy_id = g.id WHERE g.name = ? AND p.hasLife = TRUE";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, galaxyName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                results.add(rs.getString("name"));
            }
        }
        return results;
    }

    public static List<String> getPlanetsByRadiusAndMoons(Connection connection) throws SQLException {
        List<String> results = new ArrayList<>();
        String query = "SELECT p.name FROM Planet p LEFT JOIN Moon m ON p.id = m.planet_id GROUP BY p.id ORDER BY p.radius ASC, COUNT(m.id) DESC";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                results.add(rs.getString("name"));
            }
        }
        return results;
    }

    public static String getPlanetWithMaxMoonsAndMinMoonVolume(Connection connection) throws SQLException {
        String query = "SELECT p.name FROM Planet p LEFT JOIN Moon m ON p.id = m.planet_id GROUP BY p.id ORDER BY COUNT(m.id) DESC, SUM(m.radius) ASC LIMIT 1";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        }
        return null;
    }

    public static String getGalaxyWithMaxCoreTempSum(Connection connection) throws SQLException {
        String query = "SELECT g.name FROM Galaxy g JOIN Planet p ON g.id = p.galaxy_id GROUP BY g.id ORDER BY SUM(p.coreTemperature) DESC LIMIT 1";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        }
        return null;
    }
}
