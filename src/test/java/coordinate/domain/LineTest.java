package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 선길이_구하기_테스트() {
        Line line = new Line(new Points(Arrays.asList(
                new Point(new Scalar(1), new Scalar(2)),
                new Point(new Scalar(1), new Scalar(5))
        )));
        assertThat(line.calculateFigure()).isEqualTo(3);
    }
}
