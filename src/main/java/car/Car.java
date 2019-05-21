package car;

public abstract class Car {
    protected int tripDistance;

    public Car(int tripDistance){
        this.tripDistance = tripDistance;
    }

    abstract double getDistancePerLiter();

    double getTripDistance() {
        return (double) tripDistance;
    };

    String getName() {
        return this.getClass().toString().substring(6);
    }

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}