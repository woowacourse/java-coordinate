package fuel.domain;

public abstract class AbstractCar implements Car {
    int distance;
    int fuelEfficiency;

    @Override
    public abstract String getName();

    @Override
    public int getFuelEfficiency() {
        return distance / fuelEfficiency;
    }
}
