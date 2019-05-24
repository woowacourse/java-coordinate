package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VectorTest {
    @Test
    void innerProductTest() {
        Vector v1 = new Vector(new Line(new Point(0, 0), new Point(2, 5)));
        Vector v2 = new Vector(new Line(new Point(0, 0), new Point(3, 7)));

        assertThat(v1.innerProduct(v2)).isEqualTo(2 * 3 + 5 * 7);
    }

    @Test
    void lengthTest() {
        Vector v1 = new Vector(new Line(new Point(0, 0), new Point(1, 1)));
        assertThat(v1.length()).isEqualTo(Math.sqrt(2.0), Offset.offset(0.001));
    }
}
