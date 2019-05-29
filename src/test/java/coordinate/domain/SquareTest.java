package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
    @Test
    void null_테스트() {
        assertThrows(NullPointerException.class, () -> new Square(null));
    }

    @Test
    void 사각형_점이_4개인지_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                new Square(PointsGenerator.generatePoints("(10,10)-(22,10)-(22,18)")));
    }

    @Test
    void 직사각형_여부_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                new Square(PointsGenerator.generatePoints("(10,10)-(22,10)-(22,18)-(10,3)")));
    }

    @Test
    void 면적_테스트() {
        Square square = new Square(PointsGenerator.generatePoints("(10,10)-(22,10)-(22,18)-(10,18)"));
        assertThat(square.area()).isEqualTo(96);
    }
}
