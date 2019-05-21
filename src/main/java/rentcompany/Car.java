package rentcompany;

public abstract class Car {

    private static final String COLON = " : ";
    private static final String LITER = "리터";
    private static final String NEW_LINE = "\n";

    abstract double getDistancePerLiter();

    abstract double getTripDistance();

    abstract String getName();

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    int validDistance(int distance) {
        if(getTripDistance() < 0){
            throw new IllegalArgumentException("거리는 양수이어야 합니다.");
        }
        return distance;
    }

    @Override
    public String toString() {
        return getName() + COLON + (int)getChargeQuantity() + LITER + NEW_LINE;
    }
}
