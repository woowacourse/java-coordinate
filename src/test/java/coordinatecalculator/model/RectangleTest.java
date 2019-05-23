package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    @Test
    void 직사각형_맞는지_검증_테스트() {
        Points points = Points.create();
        points.addPoint(new Point("(1,1)"));
        points.addPoint(new Point("(1,3)"));
        points.addPoint(new Point("(2,1)"));
        points.addPoint(new Point("(2,3)"));

        assertDoesNotThrow(()->new Rectangle(points));
    }

    @Test
    void 직사각형이_아닐때_검증_테스트() {
        Points points = Points.create();
        points.addPoint(new Point("(1,2)"));
        points.addPoint(new Point("(1,3)"));
        points.addPoint(new Point("(2,1)"));
        points.addPoint(new Point("(2,3)"));

        assertThrows(IllegalArgumentException.class, () ->
            new Rectangle(points)
        );
    }

    @Test
    void 직사각형_넓이_구하는_테스트() {
        Points points = Points.create();
        points.addPoint(new Point("(1,1)"));
        points.addPoint(new Point("(1,3)"));
        points.addPoint(new Point("(2,1)"));
        points.addPoint(new Point("(2,3)"));

        assertThat(new Rectangle(points).calculateRectangleArea()).isEqualTo(2);
    }
}
