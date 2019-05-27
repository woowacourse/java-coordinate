package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void 직사각형_넓이_테스트() {
        String testString = "(0,0)-(5,4)-(5,0)-(0,4)";
        Points testPoints = PointsFactory.generatePoints(testString);
        Figure testFigure = FigureFactory.generateFigure(testPoints);
        assertThat(testFigure.area()).isEqualTo(20, offset(0.00099));
    }

    @Test
    void 직사각형_아닌_네점_유효성_테스트() {
        String testString = "(1,1)-(1,2)-(3,4)-(2,5)";
        Points testPoints = PointsFactory.generatePoints(testString);
        assertThrows(IllegalArgumentException.class, ()-> FigureFactory.generateFigure(testPoints));
    }

}
