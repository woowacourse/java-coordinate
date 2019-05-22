package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void 사이즈_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(new PointsGenerator("(10,10)-(14,15)").generate()));
    }

    @Test
    void 면적_테스트() {
        Triangle triangle = new Triangle(new PointsGenerator("(10,10)-(14,15)-(20,8)").generate());
        assertThat(triangle.area()).isEqualTo(29.0, Offset.offset(0.00009));
    }
}
