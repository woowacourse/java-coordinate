package car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class K5Test {

    @Test
    void fuelEfficiencyTest() {
        K5 testK5 = new K5(350);
        assertThat(testK5.getChargeQuantity()).isEqualTo(350 / 13);
    }

    @Test
    void getNameTest() {
        K5 testK5 = new K5(350);
        assertThat(testK5.getName()).isEqualTo("car.K5");
    }
}