package rentcompany;

public class Sonata implements Car {
    private static final String name = "Sonata";
    private static final int distancePerLiter = 10; // km/Liter
    private int tripDistance;

    public Sonata(int tripDistance) {
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
