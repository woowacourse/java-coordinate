package rentcar.domain;

public class Sonata extends Car {
    private int tripDistance;
    private String name = "Sonata";
    private int distancePerLiter = 10;
    public Sonata(int tripDistance){
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
        return "Sonata : " + (int)getChargeQuantity() + "리터";
    }
}
