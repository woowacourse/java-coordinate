package coordinatecalculator.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineTest {

    private Points points;

    @BeforeEach
    void setUp() {
        points = Points.create();
        points.addPoint(new Point("(10,10)"));
        points.addPoint(new Point("(11,11)"));
    }

    @Test
    void 선의_길이가_잘_나오는지_테스트() {
        assertDoesNotThrow(() -> new Line(points));
    }

    @AfterEach
    void tearDown() {
        points = null;
    }
}
