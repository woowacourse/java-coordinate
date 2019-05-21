package rentcarcompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car avante;

    @BeforeEach
    void setUp() {
        avante = new Avante(30);
    }

    @Test
    void 연비가_제대로_가져오는지_테스트() {
        assertThat(avante.getDistancePerLiter()).isEqualTo(15);
    }

    @Test
    void 여행하려는_거리를_제대로_가져오는지_테스트() {
        assertThat(avante.getTripDistance()).isEqualTo(30);
    }

    @Test
    void 차_이름을_제대로_가져오는지_테스트() {
        assertThat(avante.getName()).isEqualTo("avante");
    }

    @Test
    void 주입해야될_연료를_제대로_계산하는지_테스트() {
        assertThat(avante.getChargeQuantity()).isEqualTo(2);
    }
}