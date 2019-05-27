package car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void initTest() {
        new Sonata(150);
    }

    @Test
    void chargeQuantityTest() {
        assertThat(new Avante(255).getChargeQuantity()).isEqualTo(17);
    }

    @Test
    void getNameTest() {
        assertThat(new K5(123).getName()).isEqualTo("K5");
    }
}