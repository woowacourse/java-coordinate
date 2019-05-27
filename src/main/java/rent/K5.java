package rent;

public class K5 implements Car {

    private static final double DISTANCE_PER_LITER = 13;
    private int tripDistance;

    public K5(int tripDistance){
        this.tripDistance = tripDistance;
    }

    @Override
    public String getName() {
        return "K5";
    }

    @Override
    public double getChargeQuantity() {
        return tripDistance / DISTANCE_PER_LITER;
    }
}
