package rentcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AvanteTest {
    Avante avante;

    @BeforeEach
    public void setup() {
        avante = new Avante(30);
    }

    @Test
    public void 연비() {
        assertThat(avante.getDistancePerLiter()).isEqualTo(15);
    }

    @Test
    public void 가야될거리() {
        assertThat(avante.getTripDistance()).isEqualTo(30);
    }

    @Test
    public void 주입연료() {
        assertThat(avante.getChargeQuantity()).isEqualTo(2);
    }



}
