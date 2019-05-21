package car;

public abstract class Car implements Chargeable {
    protected int distance;

    public Car(int distance) {
        this.distance = distance;
    }

    @Override
    public int getChargeQuantity() {
        return distance / getDistancePerLiter();
    }

    public String getName() {
        return this.getClass().getName();
    }
}
