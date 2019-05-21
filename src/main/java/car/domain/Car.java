package car.domain;

public abstract class Car {
     double distance;
     double fuelEffiency;
    /**
     * 차종의 이름
     */
    abstract String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return distance / fuelEffiency;
    }
}
