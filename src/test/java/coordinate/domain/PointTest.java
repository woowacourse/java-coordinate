package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    void 생성() {
        assertThat(new Point(10, 10)).isEqualTo(new Point(10, 10));
    }
}
