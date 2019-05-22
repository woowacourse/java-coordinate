package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @Test
    void 삼각형예외() {
        CoordinateList cl = new CoordinateList(CoordinateFactory.generateCoordinateList(Arrays.asList("1,0","2,0","3,0")));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Triangle(cl);
        });
    }

    @Test
    void 삼각형넓이() {
        CoordinateList cl = new CoordinateList(CoordinateFactory.generateCoordinateList(Arrays.asList("0,0","2,0","0,2")));
        Triangle triangle = new Triangle(cl);
        assertEquals(triangle.findArea(),2,0.001);

    }
}
