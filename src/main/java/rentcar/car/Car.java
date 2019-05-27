package rentcar.car;

public interface Car {
    /**
     * 차종의 이름
     */
    String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity();
}
