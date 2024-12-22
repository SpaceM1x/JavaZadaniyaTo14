package Vol12Var11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Airport {
    private static final int NUM_TERMINALS = 3;
    private static final int NUM_RUNWAYS = 2;

    private final Semaphore terminalAccess;
    private final Semaphore runwayAccess;
    private final ExecutorService airplaneService;

    public Airport(int numAirplanes) {
        terminalAccess = new Semaphore(NUM_TERMINALS);
        runwayAccess = new Semaphore(NUM_RUNWAYS);
        airplaneService = Executors.newFixedThreadPool(numAirplanes);
    }

    public void processAirplane(Airplane airplane) {
        airplaneService.submit(() -> {
            try {
                System.out.println(airplane + " готовится к посадке.");
                if (airplane.isUsingTerminal()) {
                    terminalAccess.acquire();
                    System.out.println(airplane + " использует терминал.");
                    airplane.boardPassengers();
                    terminalAccess.release();
                } else {
                    runwayAccess.acquire();
                    System.out.println(airplane + " использует трап.");
                    airplane.boardPassengers();
                    runwayAccess.release();
                }
                airplane.flyToDestination();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(airplane + " был прерван.");
            }
        });
    }

    public void shutdown() {
        airplaneService.shutdown();
        try {
            if (!airplaneService.awaitTermination(10, TimeUnit.SECONDS)) {
                airplaneService.shutdownNow();
            }
        } catch (InterruptedException e) {
            airplaneService.shutdownNow();
        }
    }
}
