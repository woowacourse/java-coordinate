package coordinate.model;

import coordinate.model.Line;
import coordinate.model.Point;
import coordinate.model.PointNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 라인_길이_추출() {
        Point p1 = new Point(new PointNumber(0), new PointNumber(0));
        Point p2 = new Point(new PointNumber(2), new PointNumber(0));
        assertThat(new Line(p1, p2).getLength()).isEqualTo(2.0);
    }
}
