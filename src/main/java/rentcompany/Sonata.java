package rentcompany;

import java.util.Objects;

public class Sonata implements Car {
    private final static int EFFICIENCY = 10;
    private static final String NAME = "Sonata";

    private final int distance;

    Sonata(final int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sonata sonata = (Sonata) o;
        return distance == sonata.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public int calculateFuel() {
        return distance / EFFICIENCY;
    }

    @Override
    public String generateReport() {
        return NAME + " : " + calculateFuel() + "리터\n";
    }
}
