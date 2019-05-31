package rentcompany;

public class Avante implements Car {
    private static final String name = "Avante";
    private static final int distancePerLiter = 15; // km/Liter
    private int tripDistance;

    public Avante(final int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getChargeQuantity() {
        return tripDistance / distancePerLiter;
    }
}