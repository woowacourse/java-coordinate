package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    Point testPoint1;
    Point testPoint2;
    Point testPoint3;

    @BeforeEach
    void setUp() {
        testPoint1 = new Point(Arrays.asList(1, 1));
        testPoint2 = new Point(Arrays.asList(1, 2));
        testPoint3 = new Point(Arrays.asList(2, 2));
    }

    @Test
    void 좌표가_세개가_아닐때_예외를_던지는지_테스트() {
        Points testPointsWithTwoPoints = Points.of(Arrays.asList(testPoint1, testPoint2));

        assertThrows(IllegalArgumentException.class, () -> new Triangle(testPointsWithTwoPoints));
    }

    @Test
    void 한_직선에의_세개의_좌표가_있을때_예외를_던지는지_테스트() {
        Point testPointInSameLine = new Point(Arrays.asList(3, 3));
        Points pointsInSameLine = Points.of(Arrays.asList(testPoint1, testPoint3, testPointInSameLine));

        assertThrows(IllegalArgumentException.class, () -> new Triangle(pointsInSameLine));
    }

    @Test
    void 넓이를_구하는지_테스트() {
        Points testPoints = Points.of(Arrays.asList(testPoint1, testPoint2, testPoint3));
        Triangle testTriangle = new Triangle(testPoints);

        assertThat(testTriangle.calculateArea()).isEqualTo(0.5, offset(0.00099));
    }
}