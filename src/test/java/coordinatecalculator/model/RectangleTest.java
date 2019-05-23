package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangleTest {

    @Test
    void 직사각형_맞는지_검증_테스트() {
        Points points = Points.create();
        points.addPoint(new Point("(1,1)"));
        points.addPoint(new Point("(1,3)"));
        points.addPoint(new Point("(2,1)"));
        points.addPoint(new Point("(2,3)"));

        Rectangle rectangle = new Rectangle(points);
        assertTrue(rectangle.isValid());
    }

    @Test
    void 직사각형이_아닐때_검증_테스트() {
        Points points = Points.create();
        points.addPoint(new Point("(1,2)"));
        points.addPoint(new Point("(1,3)"));
        points.addPoint(new Point("(2,1)"));
        points.addPoint(new Point("(2,3)"));

        Rectangle rectangle = new Rectangle(points);
        assertFalse(rectangle.isValid());
    }
}
