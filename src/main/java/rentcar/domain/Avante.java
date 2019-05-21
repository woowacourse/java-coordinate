package rentcar.domain;

public class Avante extends Car {
    private int tripDistance;
    private String name = "Avante";
    private int distancePerLiter = 15;
    public Avante(int tripDistance){
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
        return "Avante : " + (int)getChargeQuantity() + "리터";
    }
}
