package rent;

public class Sonata implements Car {
    private static final double DISTANCE_PER_LITER = 10;
    private int tripDistance;

    public Sonata(int tripDistance){
        this.tripDistance = tripDistance;
    }
    @Override
    public String getName() {
        return "Sonata";
    }

    @Override
    public double getChargeQuantity() {
        return tripDistance / DISTANCE_PER_LITER;
    }
}