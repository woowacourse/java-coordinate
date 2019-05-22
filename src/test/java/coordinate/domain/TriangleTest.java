package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void name() {
        double s = (4 + 5 + 3) / 2.0d;
        double x = (s * (s - 4) * (s - 5) * (s - 3));
        double Area = Math.sqrt(x);
        System.out.println(Area);
    }


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
