package Vol12Var11;

public class Airplane {
    private final String name;
    private final boolean useTerminal;
    public final String destination;
    public final int range;

    public Airplane(String name, boolean useTerminal, String destination, int range) {
        this.name = name;
        this.useTerminal = useTerminal;
        this.destination = destination;
        this.range = range;
    }

    public boolean isUsingTerminal() {
        return useTerminal;
    }

    public void boardPassengers() throws InterruptedException {
        System.out.println(name + " высаживает/набирает пассажиров.");
        Thread.sleep(1000);
    }

    public void flyToDestination() {
        System.out.println(name + " летит в " + destination + " (дальность: " + range + " км).");
    }

    @Override
    public String toString() {
        return name;
    }
}
