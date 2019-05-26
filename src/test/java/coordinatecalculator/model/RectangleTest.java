package coordinatecalculator.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    private Points points;

    @BeforeEach
    void setUp() {
        points = Points.create();
        points.addPoint(new Point("(1,1)"));
        points.addPoint(new Point("(1,3)"));
        points.addPoint(new Point("(2,1)"));
        points.addPoint(new Point("(2,3)"));
    }

    @Test
    void 직사각형_맞는지_검증_테스트() {
        assertDoesNotThrow(() -> new Rectangle(points));
    }

    @Test
    void 직사각형이_아닐때_검증_테스트() {
        points.getPoints().clear();
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
        assertThat(new Rectangle(points).getResult()).isEqualTo(2);
    }

    @AfterEach
    void tearDown() {
        points = null;
    }
}
