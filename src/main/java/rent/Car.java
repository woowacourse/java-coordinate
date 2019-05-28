package rent;

public abstract class Car implements ICar {
    protected String name;
    protected double distancePerLiter;
    protected int tripDistance;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getChargeQuantity() {
        return tripDistance / distancePerLiter;
    }
}
