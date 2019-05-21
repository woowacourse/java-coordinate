package rentcar.domain;

public class Avante extends Car {
    private int tripDistance;
    private String name = "Avante";
    private int distancePerLiter = 15;
    public Avante(int tripDistance){
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
        return "Avante : " + (int)getChargeQuantity() + "리터";
    }
}
