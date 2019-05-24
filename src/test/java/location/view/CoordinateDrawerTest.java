package location.view;

import location.domain.Point;
import location.domain.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CoordinateDrawerTest {
    @Test
    void 출력테스트 (){
        new CoordinateDrawer(new Points(Arrays.asList(new Point(5,2),new Point(6,5))));
    }
}
