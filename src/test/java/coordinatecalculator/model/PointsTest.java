package coordinatecalculator.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointsTest {

    private Points points;

    @BeforeEach
    void setUp() {
        points = Points.create();
        points.addPoint(new Point("(1,1)"));
        points.addPoint(new Point("(2,2)"));
    }

    @Test
    void 점_생성_테스트() {
        assertThat(points.getPoint(0)).isEqualTo(new Point("(1,1)"));
        assertThat(points.getPoint(1)).isEqualTo(new Point("(2,2)"));
    }

    @Test
    void 거리계산_테스트() {
        assertEquals(1.414, points.distanceResult(), 0.001);
    }

    @AfterEach
    void tearDown() {
        points = null;
    }
}
