package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointsGeneratorTest {
    @Test
    void 점_2개_생성() {
        Points points = new Points(Arrays.asList(new Point(14, 15), new Point(10, 10)));
        assertThat(PointsGenerator.generate("(10,10)-(14,15)")).isEqualTo(points);
    }

    @Test
    void 점_3개_생성() {
        Points points = new Points(Arrays.asList(
                new Point(1, 5),
                new Point(1, 1),
                new Point(5, 1)));

        assertThat(PointsGenerator.generate("(1,5)-(1,1)-(5,1)")).isEqualTo(points);
    }

    @Test
    void 점_4개_생성() {
        Points points = new Points(Arrays.asList(
                new Point(1, 5),
                new Point(1, 1),
                new Point(5, 1),
                new Point(5, 5)));
        assertThat(PointsGenerator.generate("(1,5)-(1,1)-(5,1)-(5,5)")).isEqualTo(points);
    }

    @Test
    void 잘못된_식인_경우() {
        assertThatThrownBy(() -> PointsGenerator.generate("(10)-(14,15)"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
