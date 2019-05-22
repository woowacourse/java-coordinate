package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TriangleTest {

    @Test
    void 삼각형예외() {
        CoordinateList cl = new CoordinateList(CoordinateFactory.generateCoordinateList(Arrays.asList("1,0","2,0","3,0")));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Triangle(cl);
        });
    }
}
