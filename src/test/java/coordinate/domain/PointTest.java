package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 생성자_테스트() {
        Point point = new Point(new Coordinate(10), new Coordinate(10));
        assertThat(point).isEqualTo(new Point(new Coordinate(10), new Coordinate(10)));
    }
}
