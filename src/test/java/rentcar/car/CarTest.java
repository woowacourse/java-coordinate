package rentcar.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void create() {
        Car car = new Sonata(150);
        assertThat(car.getChargeQuantity()).isEqualTo(15);
    }
}