package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineTest {
    @Test
    public void 두_점_사이의_거리를_제대로_출력해주는지_테스트() {
        Point pointA = new Point(new Coordinate(10), new Coordinate(10));
        Point pointB = new Point(new Coordinate(14), new Coordinate(15));
        assertThat(Line.length(pointA, pointB)).isEqualTo(6.403124, offset(0.00099));
    }
}
