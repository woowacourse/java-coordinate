package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;

public class TriangleTest {
    @Test
    void 삼각형_넓이_테스트() {
        String testString = "(0,0)-(8,0)-(0,8)";
        Figure testFigure = FigureFactory.generateFigure(testString);
        assertThat(testFigure.area()).isEqualTo(32, offset(0.00099));
    }
}
