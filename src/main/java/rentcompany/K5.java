package rentcompany;

public class K5 implements Car {
    private static final String name = "K5";
    private static final int distancePerLiter = 13; // km/Liter
    private int tripDistance;

    public K5(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return distancePerLiter;
    }

    @Override
    public double getTripDistance() {
        return this.tripDistance;
    }

    @Override
    public String getName() {
        return name;
    }
}