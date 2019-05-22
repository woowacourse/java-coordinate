package fuel.domain;

public abstract class Car {
    abstract int getDistancePerLitter();

    abstract int getDistance();

    abstract String getName();

    public int getFuel() {
        return getDistance() / getDistancePerLitter();
    }

}
