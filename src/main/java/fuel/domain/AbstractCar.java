package fuel.domain;

abstract class AbstractCar implements Car {

    @Override
    public abstract int getDistancePerLitter();

    @Override
    public abstract int getDistance();

    @Override
    public abstract String getName();

    @Override
    public int getFuel() {
        return getDistance() / getDistancePerLitter();
    }

}
