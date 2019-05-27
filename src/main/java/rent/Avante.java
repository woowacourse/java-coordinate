package rent;

public class Avante implements Car {

    private static final double DISTANCE_PER_LITER = 15;
    private int tripDistance;

    public Avante(int tripDistance){
        this.tripDistance = tripDistance;
    }

    @Override
    public String getName() {
        return "Avante";
    }

    @Override
    public double getChargeQuantity() {
        return tripDistance / DISTANCE_PER_LITER;
    }
}
