package rentcarcompany;

public abstract class Car {
    private int distance;
    private int distacnePerLitter;

    Car(int distance, int distacnePerLitter) {
        this.distance = distance;
        this.distacnePerLitter = distacnePerLitter;
    }

    /**
     * 차종의 이름
     */
    abstract String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return distance / distacnePerLitter;
    }
}
