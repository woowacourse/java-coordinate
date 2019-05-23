package rentcar.domain;

public class K5 extends Car {
    private int tripDistance;
    private String name = "K5";
    private int distancePerLiter = 13;
    public K5(int tripDistance){
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return distancePerLiter;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + (int)getChargeQuantity() + "리터";
    }
}