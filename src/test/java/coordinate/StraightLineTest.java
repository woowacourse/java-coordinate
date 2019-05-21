package coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class StraightLineTest {
    @Test
    void 두_점은_같을_수_없다() {
        Point point = new Point(1, 2);
        Point point1 = new Point(1, 2);
        assertThrows(IllegalArgumentException.class, () -> new StraightLine(point, point1));
    }
}
