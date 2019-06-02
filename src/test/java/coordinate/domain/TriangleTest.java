package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void 점2개가_입력되는_경우_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(PointsGenerator.generatePoints("(10,10)-(14,15)")));
    }

    @Test
    void 삼각형_면적_29인_경우_테스트() {
        Triangle triangle = new Triangle(PointsGenerator.generatePoints("(10,10)-(14,15)-(20,8)"));
        assertThat(triangle.area()).isEqualTo(29.0, Offset.offset(0.00009));
    }
}
