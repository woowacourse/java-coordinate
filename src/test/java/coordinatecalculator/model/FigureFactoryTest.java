package coordinatecalculator.model;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FigureFactoryTest {
    @Test
    void 선분_생성_테스트() {
        String testString = "(1,1)-(2,2)";
        Points testPoints = PointsFactory.generatePoints(testString);
        Figure testFigure = FigureFactory.generateFigure(testPoints);

        Points testPoints2 = PointsFactory.generatePoints(testString);
        Line testLine = new Line(testPoints2);

        assertThat(testLine).isEqualTo(testFigure);
    }

    @Test
    void 삼각형_생성_테스트() {
        String testString = "(1,1)-(2,2)-(3,4)";
        Points testPoints = PointsFactory.generatePoints(testString);
        Figure testFigure = FigureFactory.generateFigure(testPoints);

        Points testPoints2 = PointsFactory.generatePoints(testString);
        Triangle testTriangle = new Triangle(testPoints2);

        assertThat(testTriangle).isEqualTo(testFigure);
    }

    @Test
    void 사각형_생성_테스트() {
        String testString = "(0,0)-(3,0)-(3,4)-(0,4)";
        Points testPoints = PointsFactory.generatePoints(testString);
        Figure testFigure = FigureFactory.generateFigure(testPoints);

        Points testPoints2 = PointsFactory.generatePoints((testString));
        Rectangle testRectangle = new Rectangle(testPoints2);

        assertThat(testRectangle).isEqualTo(testFigure);
    }
}
