package rentcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class K5Test {
    K5 k5;

    @BeforeEach
    public void setup() {
        k5 = new K5(26);
    }

    @Test
    public void 연비() {
        assertThat(k5.getDistancePerLiter()).isEqualTo(13);
    }

    @Test
    public void 가야될거리() {
        assertThat(k5.getTripDistance()).isEqualTo(26);
    }

    @Test
    public void 주입연료() {
        assertThat(k5.getChargeQuantity()).isEqualTo(2);
    }


}
