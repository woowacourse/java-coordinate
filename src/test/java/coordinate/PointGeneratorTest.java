package coordinate;

import coordinate.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PointGeneratorTest {
    String input = "(1,2)-(3,4)-(5,6)";

    @Test
    void 생성() {
        assertEquals(Arrays.asList(new Point(1, 2), new Point(3, 4), new Point(5, 6)),
                PointGenerator.trans(InputView.parse(input)));
    }
}