package rent;

public abstract class Car {
    private static final String NEWLINE = System.getProperty("line.separator");
    private String name;
    private double distancePerLiter;
    private double tripDistance;

    public Car(String name, double distancePerLiter, double tripDistance) {
        this.name = name;
        this.distancePerLiter = distancePerLiter;
        this.tripDistance = tripDistance;
    }

    public double getDistancePerLiter() {
        return distancePerLiter;
    }

    public double getTripDistance() {
        return tripDistance;
    }

    public String getName() {
        return name;
    }

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    @Override
    public String toString() {
        return name + " : " + String.format("%d", (int) getChargeQuantity()) + "리터" + NEWLINE;
    }
}
