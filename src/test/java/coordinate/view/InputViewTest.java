package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.FigureFactory;
import coordinate.model.Line;
import coordinate.model.Point;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private List<Point> points;

    @BeforeEach
    void setUp() {
        points = new ArrayList<>();
    }

    @Test
    void 사용자_입력에_따른_Line_생성() {
        Figure figure = InputView.inputCoordinates("(1, 1) - (2, 2)");
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        assertThat(figure).isEqualTo(FigureFactory.create(points));
    }

    @Test
    void 사용자_입력에_따른_Triangle_생성() {
        Figure figure = InputView.inputCoordinates("(1, 1) - (3, 2) - (2, 5)");
        points.add(new Point(1, 1));
        points.add(new Point(3, 2));
        points.add(new Point(2, 5));
        assertThat(figure).isEqualTo(FigureFactory.create(points));
    }

    @Test
    void 사용자_입력에_따른_Rectangle_생성() {
        Figure figure = InputView.inputCoordinates("(1, 5) - (3, 5) - (1, 3) - (3, 3)");
        points.add(new Point(1, 5));
        points.add(new Point(3, 5));
        points.add(new Point(1, 3));
        points.add(new Point(3, 3));
        assertThat(figure).isEqualTo(FigureFactory.create(points));
    }

    @AfterEach
    void tearDown() {
        points = null;
    }
}