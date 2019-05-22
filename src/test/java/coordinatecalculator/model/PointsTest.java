package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {

    @Test
    void 점_생성_테스트() {
        Point point = new Point("1", "1");
        Points points = Points.create();
        points.addPoint(point);
        assertThat(points.getPoint(0)).isEqualTo(point);
    }
}
