package coord.model.Coordinate;

import coord.model.Point;
import coord.model.Points;
import coord.view.CoordinateView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CoordinateViewTest {

    @Test
    void 프린트() {
        Points points = new Points(Arrays.asList(new Point(1, 2), new Point(5, 6)));
        CoordinateView coordinateView = new CoordinateView(points);
        coordinateView.print();
    }

}