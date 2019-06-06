package rentcompany;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SonataTest {
    @Test
    void 이동거리가_음수일_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Sonata(-1));
    }

    @Test
    public void 이동거리가_0일_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Sonata(0));
    }

    @Test
    void 주입해야할_연료량을_제대로_반환하는지_테스트() {
        Sonata sonata = new Sonata(100);

        assertThat(sonata.getChargeQuantity()).isEqualTo(10);
    }
}
