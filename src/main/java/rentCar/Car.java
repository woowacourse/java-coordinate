package rentCar;

abstract class Car {
    private final double tripDistance;
    private final String name;
    private final double distancePerLiter;

    Car(int movingDistance, String name, int distancePerLiter) {
        this.tripDistance = movingDistance;
        this.name = name;
        this.distancePerLiter = distancePerLiter;
    }

    private double getDistancePerLiter() {
        return distancePerLiter;
    }

    private double getTripDistance() {
        return tripDistance;
    }

    String getName() {
        return name;
    }

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}