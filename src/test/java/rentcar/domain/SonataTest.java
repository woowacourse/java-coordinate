package rentcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SonataTest {
    Sonata sonata;

    @BeforeEach
    public void setup() {
        sonata = new Sonata(20);
    }

    @Test
    public void 연비() {
        assertThat(sonata.getDistancePerLiter()).isEqualTo(10);
    }

    @Test
    public void 가야될거리() {
        assertThat(sonata.getTripDistance()).isEqualTo(20);
    }

    @Test
    public void 주입연료() {
        assertThat(sonata.getChargeQuantity()).isEqualTo(2);
    }

}
