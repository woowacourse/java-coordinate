package location.view;

import location.domain.Point;
import location.domain.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CoordinateDrawerTest {
    @Test
    void x라인_0점_출력() {
        new CoordinateDrawer(new Points(Arrays.asList(new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1))));
    }

    @Test
    void 원점_출력() {
        new CoordinateDrawer(new Points(Arrays.asList(new Point(0, 0), new Point(2, 0), new Point(1, 1), new Point(2, 1))));
    }

    @Test
    void y라인_0점_출력() {
        new CoordinateDrawer(new Points(Arrays.asList(new Point(1, 0), new Point(2, 0), new Point(1, 1), new Point(2, 1))));
    }
}
