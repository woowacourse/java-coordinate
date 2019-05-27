package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void create() {
        assertThat(new Point("1", "2")).isEqualTo(new Point("1", "2"));
    }
}
