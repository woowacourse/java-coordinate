package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 선길이_구하기_테스트() {
        Line line = new Line(new Point(1, 2), new Point(1, 5));
        assertThat(line.calLength()).isEqualTo(3);
    }
}
