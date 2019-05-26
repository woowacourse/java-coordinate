package coordinatecalculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TriangleTest {

    private Points points;

    @BeforeEach
    void setUp() {
        points = Points.create();
        points.addPoint(new Point("(10,10)"));
        points.addPoint(new Point("(14,15)"));
        points.addPoint(new Point("(20,8)"));
    }

    @Test
    void 삼각형이_맞는지_검증_테스트() {
        assertDoesNotThrow(() -> new Triangle(points));
    }

    @Test
    void 삼각형이_아닐때_검증_테스트() {
        points.getPoints().clear();
        points.addPoint(new Point("(10,10)"));
        points.addPoint(new Point("(11,11)"));
        points.addPoint(new Point("(20,8)"));
        assertThrows(IllegalArgumentException.class, () ->
                new Triangle(points)
        );
    }

    @Test
    void 삼각형_넓이_구하는_테스트() {
        assertThat(new Triangle(points).getResult()).isEqualTo(29.0);
    }
}
