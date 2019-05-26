package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;

public class RectangleTest {
    @Test
    void 직사각형_넓이_테스트() {
        String testString = "(0,0)-(5,4)-(5,0)-(0,4)";
        Figure testFigure = FigureFactory.generateFigure(testString);
        assertThat(testFigure.area()).isEqualTo(20, offset(0.00099));
    }

}
