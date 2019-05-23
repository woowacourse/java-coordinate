package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureRouterTest {
    @Test
    void 선분으로_분류가_잘되는지() {
        Points points = new Points(Arrays.asList(new Point("0", "0"), new Point("1", "0")));
        assertThat(FigureRouter.routing(points)).isInstanceOf(Line.class);
    }

    @Test
    void 삼각형으로_분류가_잘되는지() {
        Points points = new Points(Arrays.asList(new Point("0", "0"), new Point("1", "0"), new Point("0", "1")));
        assertThat(FigureRouter.routing(points)).isInstanceOf(Triangle.class);
    }

    @Test
    void 사각형으로_분류가_잘되는지() {
        Points points = new Points(Arrays.asList(new Point("0", "0"), new Point("1", "0"), new Point("0", "1"), new Point("1", "1")));
        assertThat(FigureRouter.routing(points)).isInstanceOf(Rectangle.class);
    }
}
