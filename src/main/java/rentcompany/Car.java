package rentcompany;

import java.util.Objects;

public class Car implements Vehicle {
    private final int efficiency;
    private final String name;
    private final int distance;

    public Car(int efficiency, String name, int distance) {
        this.efficiency = efficiency;
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int calculateFuel() {
        return distance / efficiency;
    }

    @Override
    public String generateReport() {
        return name + " : " + calculateFuel() + "리터\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return efficiency == that.efficiency &&
                distance == that.distance &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(efficiency, name, distance);
    }
}
