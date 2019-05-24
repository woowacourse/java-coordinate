package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RectangleTest {
    @Test
    void 사각형이_4점인지_테스트() {
        Points points = new Points(Arrays.asList(new Point(1, 3),
                new Point(1,5), new Point(3, 3)));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Rectangle(points);
        }).withMessage("4개의 점으로 구성되어야 합니다");
    }

    @Test
    void 사각형의_4각이_직각인지_테스트() {
        Points points = new Points(Arrays.asList(new Point(1, 3),
                new Point(1,5), new Point(3, 3), new Point(3,6)));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Rectangle(points);
        }).withMessage("직사각형이 아닙니다");
    }

    @Test
    void 사각형의_유효성_예외_테스트() {
        Points points = new Points(Arrays.asList(new Point(1, 3),
                new Point(1,5), new Point(3, 3), new Point(3,6)));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Rectangle(points);
        }).withMessage("직사각형이 아닙니다");
    }

    @Test
    void 사각형의_유효성_정상_테스트() {
        Points points = new Points(Arrays.asList(new Point(1, 1),
                new Point(1,2), new Point(2, 1), new Point(2,2)));
        assertThat(Rectangle.isRectangle(points)).isEqualTo(true);
    }

    @Test
    void 사각형_넓이_구하는_테스트() {
        Points points = new Points(Arrays.asList(new Point(1, 1),
                new Point(1,2), new Point(2, 1), new Point(2,2)));
        assertThat(new Rectangle(points).calculateFigure()).isEqualTo(1);
    }
}
