package Vol12Var11Test;

import Vol12Var11.Airplane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {

    @Test
    void testAirplaneCreation() {
        Airplane airplane = new Airplane("Boeing-737", true, "New York", 5000);

        assertEquals("Boeing-737", airplane.toString());
        assertTrue(airplane.isUsingTerminal());
        assertEquals("New York", airplane.destination);
        assertEquals(5000, airplane.range);
    }

    @Test
    void testBoardPassengers() throws InterruptedException {
        Airplane airplane = new Airplane("Airbus-A320", true, "London", 3000);

        assertDoesNotThrow(airplane::boardPassengers, "Boarding passengers should not throw any exceptions.");
    }

    @Test
    void testFlyToDestination() {
        Airplane airplane = new Airplane("Boeing-747", false, "Tokyo", 10000);

        assertDoesNotThrow(airplane::flyToDestination, "Flying to destination should not throw any exceptions.");
    }
}