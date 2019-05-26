package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class FigureFactoryTest {

    @Test
    void Figure_생성_확인() {
        Points points = new Points(Arrays.asList(new Point(1, 0), new Point(2, 0)));
        assertThat(FigureFactory.generateFigure(points)).isEqualTo(new Line(points));

        points = new Points(Arrays.asList(new Point(1, 0), new Point(3, 0), new Point(2, 1)));
        assertThat(FigureFactory.generateFigure(points)).isEqualTo(new Triangle(points));

        points = new Points(Arrays.asList(new Point(1, 0), new Point(3, 0), new Point(1, 1), new Point(3, 1)));
        assertThat(FigureFactory.generateFigure(points)).isEqualTo(new Rectangle(points));
    }

}
