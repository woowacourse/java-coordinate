package RentCompany;

import java.util.Objects;

public class K5 implements Car {
    private static final String NAME = "K5";
    private static final int EFFICIENCY = 13;

    private final int distance;

    K5(int distance) {
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
        K5 k5 = (K5) o;
        return distance == k5.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
