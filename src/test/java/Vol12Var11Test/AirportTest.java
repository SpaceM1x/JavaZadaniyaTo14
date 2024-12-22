package Vol12Var11Test;

import Vol12Var11.Airplane;
import Vol12Var11.Airport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
    private Airport airport;

    @BeforeEach
    void setUp() {
        airport = new Airport(5); // Создаем аэропорт для 5 самолетов
    }

    @AfterEach
    void tearDown() {
        airport.shutdown();
    }

    @Test
    void testProcessAirplaneWithTerminal() {
        Airplane airplane = new Airplane("Boeing-737", true, "Paris", 2000);

        assertDoesNotThrow(() -> airport.processAirplane(airplane));
    }

    @Test
    void testProcessAirplaneWithRunway() {
        Airplane airplane = new Airplane("Airbus-A320", false, "Berlin", 1500);

        assertDoesNotThrow(() -> airport.processAirplane(airplane));
    }

}
