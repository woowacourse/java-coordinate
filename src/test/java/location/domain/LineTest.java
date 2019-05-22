package location.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 동일한_점_일때() {
        assertThrows(IllegalArgumentException.class, () -> new Line(new Point(10, 10), new Point(10, 10)));
    }

    @Test
    void 거리계산() {
        Line line = new Line(new Point(10, 10), new Point(10, 20));
        assertThat(line.calculate()).isEqualTo(10);
    }
}
