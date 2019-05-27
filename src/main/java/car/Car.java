package car;

public abstract class Car {
    protected final int tripDistance;

    public Car(int tripDistance){
        this.tripDistance = tripDistance;
    }

    public abstract int getDistancePerLiter();

    public int getTripDistance() {
        return tripDistance;
    };

    public String getName() {
        return this.getClass().toString().substring(10);
    }

    public int getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}