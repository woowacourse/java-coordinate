package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void 길이_계산() {
        Points points = new Points(Arrays.asList(new Point(1, 0), new Point(2, 0)));
        Line line = new Line(points);
        assertThat(line.calculateArea()).isEqualTo(1);
    }
}
