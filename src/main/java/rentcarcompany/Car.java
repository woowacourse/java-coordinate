package rentcarcompany;

public abstract class Car implements CarInformation {
    private int distance;
    private int distacnePerLitter;

    Car(int distance, int distacnePerLitter) {
        this.distance = distance;
        this.distacnePerLitter = distacnePerLitter;
    }

    /**
     * 주입해야할 연료량을 구한다.
     */
    @Override
    public double getChargeQuantity() {
        return (double) distance / distacnePerLitter;
    }
}
