package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineTest {
    @Test
    void 라인_길이_추출() {
        Point p1 = new Point(new PointNumber(0), new PointNumber(0));
        Point p2 = new Point(new PointNumber(2), new PointNumber(0));
        assertThat(new Line(Arrays.asList(p1, p2)).getScore()).isEqualTo(2.0, offset(0.00099));
    }
}
