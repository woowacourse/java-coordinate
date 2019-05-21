package rentcompany;

public abstract class Car implements ICar {

    private static final String COLON = " : ";
    private static final String LITER = "리터";
    private static final String NEW_LINE = "\n";
    private static final int MIN_DISTANCE = 0;

    private double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    int validDistance(int distance) {
        if (getTripDistance() < MIN_DISTANCE) {
            throw new IllegalArgumentException("거리는 양수이어야 합니다.");
        }
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(getName())
                .append(COLON)
                .append((int) getChargeQuantity())
                .append(LITER)
                .append(NEW_LINE)
                .toString();
    }
}
