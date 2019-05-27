package coordinatecalculator.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    private Points points;

    @BeforeEach
    void setUp() {
        String[] inputPoints = {"(10,10)", "(11,11)"};
        points = Points.create(inputPoints);
    }

    @Test
    void 선의_길이가_잘_나오는지_테스트() {
        assertDoesNotThrow(() -> new Line(points));
    }

    @Test
    void 거리계산_테스트() {
        assertEquals(1.414, new Line(points).getResult(), 0.001);
    }

    @AfterEach
    void tearDown() {
        points = null;
    }
}
