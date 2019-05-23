package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TriangleTest {
    @Test
    void 삼각형_넓이_계산() {
        Points points = new Points(Arrays.asList(
                new Point(1, 5),
                new Point(1, 1),
                new Point(5, 1)));

        assertThat(new Triangle(points).calculateResult()).isEqualTo(8);
    }

    @Test
    void 세_점이_일직선에_있는_경우() {
        Points points = new Points(Arrays.asList(
                new Point(1, 2),
                new Point(3, 4),
                new Point(5, 6)));

        assertThatThrownBy(() -> new Triangle(points)).isInstanceOf(IllegalArgumentException.class);
    }
}
