package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    Point testPoint1;
    Point testPoint2;
    Point testPoint3;
    Point testPoint4;

    @BeforeEach
    void setUp() {
        testPoint1 = new Point(Arrays.asList(1, 1));
        testPoint2 = new Point(Arrays.asList(1, 2));
        testPoint3 = new Point(Arrays.asList(2, 2));
        testPoint4 = new Point(Arrays.asList(2, 1));
    }

    @Test
    void 좌표가_네개가_아닐때_예외를_던지는지_테스트() {
        Points testPointsWithTwoPoints = Points.of(Arrays.asList(testPoint1, testPoint2, testPoint3));

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(testPointsWithTwoPoints));
    }

    @Test
    void 한_직선에_세개_이상의_좌표가_있을때_예외를_던지는지_테스트() {
        Point pointInSameLine = new Point(Arrays.asList(3, 1));
        Points points = Points.of(Arrays.asList(testPoint1, testPoint3, testPoint4, pointInSameLine));

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    void 직사각형이_아닌_경우_예외를_던지는지_테스트() {
        Point pointNotInRectangle = new Point(Arrays.asList(1, 3));
        Points points = Points.of(Arrays.asList(testPoint1, pointNotInRectangle, testPoint3, testPoint4));

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    void 넓이를_구하는지_테스트() {
        Points points = Points.of(Arrays.asList(testPoint1, testPoint2, testPoint3, testPoint4));
        Rectangle testRectangle = new Rectangle(points);

        assertThat(testRectangle.calculateArea()).isEqualTo(1);
    }
}
