package location.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 거리계산() {
        Points points = new Points(Arrays.asList(new Point(10, 10), new Point(10, 20)));
        Line line = new Line(points);
        assertThat(line.calculateLine()).isEqualTo(10);
    }
}
