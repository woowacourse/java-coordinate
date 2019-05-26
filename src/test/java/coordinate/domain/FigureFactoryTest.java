package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    void 좌표_한개() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            FigureFactory.generateFigure(new Points(Arrays.asList(new Point(1, 0))));
        });
    }

    @Test
    void 좌표_다섯개() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            FigureFactory.generateFigure(new Points(Arrays.asList(new Point(1, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0), new Point(4, 0), new Point(5, 0))));
        });
    }

}
