package coordinate.model;

import coordinate.model.PointGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointGeneratorTest {

    @Test
    void 잘못된_형식_좌표_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
           new PointGenerator("(0,0)=(1,1)");
        });
    }

    
}
