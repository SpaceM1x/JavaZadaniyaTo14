package Vol12Var11;

public class Main {
    public static void main(String[] args) {
        int numAirplanes = 10;
        Airport airport = new Airport(numAirplanes);

        for (int i = 0; i < numAirplanes; i++) {
            Airplane airplane = new Airplane("Самолет-" + (i + 1),
                    (i % 2 == 0),
                    "Пункт назначения-" + (i % 4 + 1),
                    (i % 3 + 1) * 1000);
            airport.processAirplane(airplane);
        }

        airport.shutdown();
    }
}
