package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void 삼각형_넓이_테스트() {
        String testString = "(0,0)-(8,0)-(0,8)";
        Points testPoints = PointsFactory.generatePoints(testString);
        Figure testFigure = FigureFactory.generateFigure(testPoints);
        assertThat(testFigure.area()).isEqualTo(32, offset(0.00099));
    }

    @Test
    void 세점이_일직선_위에_있을때_테스트() {
        String testString = "(1,1)-(2,2)-(3,3)";
        Points testPoints = PointsFactory.generatePoints(testString);
        assertThrows(IllegalArgumentException.class, ()-> FigureFactory.generateFigure(testPoints));
    }
}
