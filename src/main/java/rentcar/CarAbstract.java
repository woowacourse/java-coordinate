package rentcar;

public class CarAbstract implements Car {
    private final String carName;
    private final int distance;
    private final int distancePerLiter;

    CarAbstract(String carName, int distance, int distancePerLiter) {
        this.carName = carName;
        this.distance = distance;
        this.distancePerLiter = distancePerLiter;
    }

    /**
     * 차종의 이름
     */
    public String getName() {
        return carName;
    }

    /**
     * 주입해야할 연료량을 구한다.
     */
    public double getChargeQuantity() {
        return distance / distancePerLiter;
    }
}
