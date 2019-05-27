package coordinate.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VerticesTest {
    Vertices vertices;

    @BeforeEach
    void setUp() {
        Point point = new Point(new Value(1), new Value(1));
        Point point1 = new Point(new Value(0), new Value(0));
        Point point2 = new Point(new Value(1), new Value(0));
        Point point3 = new Point(new Value(0), new Value(1));

        vertices = new Vertices(Arrays.asList(point, point1, point2, point3));
    }

    @Test
    void 기준점_테스트() {
        assertThat(vertices.getStandardPoint()).isEqualTo(new Point(new Value(1), new Value(1)));
    }

    @Test
    void 가장_멀리있는점_테스트() {
        assertThat(vertices.getTheFarthestPoint()).isEqualTo(new Point(new Value(0), new Value(0)));
    }

    @Test
    void 거리_계산_테스트() {
        assertThat(vertices.calculatorDistance(1, 2)).isEqualTo(Math.sqrt(2));
    }

    @Test
    void 벡터_생성_테스트() {
        Vector vector = new Vector(new Point(new Value(1), new Value(1)), new Point(new Value(0), new Value(1)));
        assertThat(vertices.getVector(1, 2).equals(vector));
    }
}