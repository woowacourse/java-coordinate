package location.view;

import location.domain.Point;
import location.domain.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class inputViewTest {

    @Test
    void 인풋_테스트() {
        List<Point> points = InputView.makeCoordinate("(10,20)-(15,24)");
        assertThat(points).contains(new Point(10, 20), new Point(15, 24));
    }

    @Test
    void 테스트() {
        List<Point> points = InputView.makeCoordinate("(10,20)-(15,24)-(12,23)");
        assertThat(points).contains(new Point(10, 20), new Point(15, 24), new Point(12, 23));
    }

    @Test
    void 점_생성() {
        List<Point> points = InputView.makeCoordinate("(10,20)");
        assertThat(points).contains(new Point(10, 20));
    }

    @Test
    void 정규식_빈값() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.makeCoordinate("(10,20)-(,24)");
        });
    }

    @Test
    void 정규식_가운데_이중대쉬() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.makeCoordinate("(10,20)--(10,24)");
        });
    }

    @Test
    void 정규식_끝_대쉬() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.makeCoordinate("(10,20)-(10,24)-");
        });
    }

    @Test
    void 정규식_네개_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.makeCoordinate("(10,20)-(10,24)-(10,20)-(10,24)-(10,24)");
        });
    }
}
