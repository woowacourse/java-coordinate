package RentCompany;

import java.util.Objects;

public class Avante implements Car {
    private static final int EFFICIENCY = 15;
    private static final String NAME = "Avante";

    private final int distance;

    public Avante(int distance) {
        this.distance = distance;
    }


    @Override
    public int calculateFuel() {
        return distance / EFFICIENCY;
    }

    @Override
    public String generateReport() {
        return NAME + " : " + calculateFuel() + "리터\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avante avante = (Avante) o;
        return distance == avante.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
