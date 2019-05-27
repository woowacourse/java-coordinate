package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    @Test
    void 선분길이_구하기_테스트() {
        String testString = "(0,0)-(5,0)";
        Points testPoints = PointsFactory.generatePoints(testString);
        Figure testFigure = FigureFactory.generateFigure(testPoints);
        assertThat(testFigure.distance(0,1)).isEqualTo(5);
    }
}
