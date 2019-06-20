package rentcompany;

public class Avante implements Car {
    private static final String name = "Avante";
    private static final int distancePerLiter = 15; // km/Liter
    private int tripDistance;

    public Avante(int tripDistance) {
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