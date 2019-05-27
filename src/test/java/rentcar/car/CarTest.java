package rentcar.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void sonata() {
        Car car = new Sonata(150);
        assertThat(car.getChargeQuantity()).isEqualTo(15);
    }

    @Test
    void k5() {
        Car car = new K5(130);
        assertThat(car.getChargeQuantity()).isEqualTo(10);
    }

    @Test
    void avante() {
        Car car = new Avante(150);
        assertThat(car.getChargeQuantity()).isEqualTo(10);
    }
}