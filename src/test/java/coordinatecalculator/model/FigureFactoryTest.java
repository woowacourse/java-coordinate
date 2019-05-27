package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureFactoryTest {
    private Points points;

    @Test
    void 도형_팩토리에서_라인이_잘_나오는지_테스트() {
        String[] linePoints = {"(1,1)", "(2,2)"};
        points = new Points(linePoints);
        assertThat(new FigureFactory().create(points)).isEqualTo(new Line(points));
    }

    @Test
    void 도형_팩토리에서_사각형이_잘_나오는지_테스트() {
        String[] rectanglePoints = {"(1,1)", "(1,3)","(2,1)","(2,3)"};
        points = new Points(rectanglePoints);
        assertThat(new FigureFactory().create(points)).isEqualTo(new Rectangle(points));

    }

    @Test
    void 도형_팩토리에서_삼각형이_잘_나오는지_테스트() {
        String[] trianglePoints = {"(1,1)", "(1,2)","(2,2)"};
        points = new Points(trianglePoints);
        assertThat(new FigureFactory().create(points)).isEqualTo(new Triangle(points));
    }
}
