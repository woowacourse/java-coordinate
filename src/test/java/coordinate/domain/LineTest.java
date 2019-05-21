package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineTest {
    @Test
    void 거리_계산() {
        Point startPoint = new Point(10,10);
        Point endPoint = new Point(14,15);

        assertThat(new Line(startPoint, endPoint).length()).isEqualTo(6.403124, offset(0.00099));
    }
}
