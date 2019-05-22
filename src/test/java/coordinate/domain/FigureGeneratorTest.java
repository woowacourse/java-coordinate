package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FigureGeneratorTest {
    @Test
    void 선_생성() {
        Points points = new Points(Arrays.asList(new Point(14, 15), new Point(10, 10)));
        Line line = new Line(points);

        assertThat(FigureGenerator.generate("(10,10)-(14,15)")).isEqualTo(line);
    }

    @Test
    void 삼각형_생성() {
        Points points = new Points(Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));
        Triangle triangle = new Triangle(points);
        assertThat(FigureGenerator.generate("(1,5)-(1,1)-(5,1)")).isEqualTo(triangle);
    }

    @Test
    void 사각형_생성() {
        Points points = new Points(Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1), new Point(5, 5)));
        Rectangle rectangle = new Rectangle(points);
        assertThat(FigureGenerator.generate("(1,5)-(1,1)-(5,1)-(5,5)")).isEqualTo(rectangle);
    }

    @Test
    void 잘못된_식인_경우() {
        assertThatThrownBy(() -> FigureGenerator.generate("(10)-(14,15)")).isInstanceOf(IllegalArgumentException.class);
    }
}
