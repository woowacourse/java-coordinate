package rentcompany;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public abstract class Car {

    private double distancePerLister;
    private double tripDistance;

    public Car(double distancePerLister, double tripDistance) {
        this.distancePerLister = distancePerLister;
        this.tripDistance = tripDistance;
    }

    /**
     * 차종의 이름
     */
    abstract String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return tripDistance / distancePerLister;
    }
}
