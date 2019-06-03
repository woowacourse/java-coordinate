package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointsTest {
    Point testpoint1;

    @BeforeEach
    void setUp() {
         testpoint1 = new Point(Arrays.asList(1, 2));
    }

    @Test
    void 겹쳐진_좌표를_입력받았을_때_예외를_던지는지_테스트() {
        Point testpoint2 = new Point(Arrays.asList(1, 2));

        assertThrows(IllegalArgumentException.class, () -> Points.of(Arrays.asList(testpoint1, testpoint2)));
    }

    @Test
    void 포인트_리스트를_제대로_반환하는지_테스트() {
        Point testpoint2 = new Point(Arrays.asList(3,4));

        assertThat(Points.of("(1,2)-(3,4)")).isEqualTo(Points.of(Arrays.asList(testpoint1, testpoint2)));
    }

    @Test
    void 소괄호로_둘러쌓여_있지않은경우_에러를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Points.of("(1,2)-3,4)"));
    }
}