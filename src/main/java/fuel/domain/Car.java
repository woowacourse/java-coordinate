package fuel.domain;

abstract class Car {
    abstract int getDistancePerLitter();
    abstract int getDistance();
    abstract String getName();

    int getFuel() {
        return getDistance() / getDistancePerLitter();
    }

}
