package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @Test
    void 삼각형예외() {
        PointList points = new PointList(PointFactory.generateCoordinateList(Arrays.asList("1,0","2,0","3,0")));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Triangle(points.findLine());
        });
    }

    @Test
    void 삼각형넓이() {
        PointList points = new PointList(PointFactory.generateCoordinateList(Arrays.asList("0,0","2,0","0,2")));
        Triangle triangle = new Triangle(points.findLine());
        assertEquals(triangle.findArea(),2,0.001);

    }
}
