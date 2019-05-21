package rentcompany;

public class Sonata {
    private static final int MIN_DISTANCE = 1;
    private int tripDistance;

    public Sonata(int tripDistance) {
        validateDistance(tripDistance);
        this.tripDistance = tripDistance;
    }

    private void validateDistance(int tripDistance) {
        if (tripDistance < MIN_DISTANCE) {
            throw new IllegalArgumentException("양수를 입력해야 합니다");
        }
    }
}
