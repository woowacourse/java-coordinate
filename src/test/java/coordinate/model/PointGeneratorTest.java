package coordinate.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointGeneratorTest {

    @Test
    void 잘못된_형식_좌표_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
           new PointGenerator("(0,0)=(1,1)");
        });
    }

    @Test
    void Point_추출_검사() {
        //assertThat(new PointGenerator("(0,0)").get)
    }
}
