package coordinate.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class HeronFormulaTest {

        @Test
        void 삼각형_넓이_계산() {
                assertThat(HeronFormula.getTriangleArea(2, 2, Math.sqrt(8))).isEqualTo(2, offset(0.00099));
        }
}
