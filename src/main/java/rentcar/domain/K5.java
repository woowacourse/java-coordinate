package rentcar.domain;

public class K5 extends Car {
    private int tripDistance;
    private String name = "K5";
    private int distancePerLiter = 13;

    public K5(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return distancePerLiter;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "K5 : " + (int) getChargeQuantity() + "리터";
    }
}