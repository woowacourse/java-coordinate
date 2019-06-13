package coordinate.domain;

import coordinate.domain.point.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VectorTest {
    @Test
    void 벡터_생성() {
        Vector vector = new Vector(new Point(0, 1), new Point(1, 2));
        assertThat(vector.toString()).isEqualTo(new Point(1, 1).toString());
    }

    @Test
    void 벡터_내적() {
        Vector vector = new Vector(new Point(0, 1), new Point(1, 2));
        Vector anotherVector = new Vector(new Point(0, 0), new Point(2,2));
        assertThat(vector.calculateInnerProduct(anotherVector)).isEqualTo(4);

        vector = new Vector(new Point(0, 0), new Point(0, 1));
        anotherVector = new Vector(new Point(0, 1), new Point(1,1));
        assertThat(vector.calculateInnerProduct(anotherVector)).isEqualTo(0);
    }

    @Test
    void 법선_벡터_확인() {
        Vector vector = new Vector(new Point(0, 1), new Point(0,2));
        Vector anotherVector = new Vector(new Point(0, 1), new Point(2,1));
        assertThat(vector.isGeneralVector(anotherVector)).isFalse();
    }

    @Test
    void 평행_벡터_확인() {
        Vector vector = new Vector(new Point(0, 1), new Point(0,2));
        Vector anotherVector = new Vector(new Point(0, 0), new Point(0, 1));
        assertThat(vector.isParallelVector(anotherVector)).isTrue();
    }
}
