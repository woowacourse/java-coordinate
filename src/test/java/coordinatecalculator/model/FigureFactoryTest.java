package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FigureFactoryTest {
    @Test
    void 선분_생성_테스트() {
        String testString = "(1,1)-(2,2)";
        Figure testFigure = FigureFactory.generateFigure(testString);
        List<String> testValues = new ArrayList<>(Arrays.asList("1","1","2","2"));
        Points testPoints = new Points(testValues);
        Line testLine = new Line(testPoints);
        assertThat(testLine).isEqualTo(testFigure);
    }

    @Test
    void 삼각형_생성_테스트() {
        String testString = "(1,1)-(2,2)-(3,4)";
        Figure testFigure = FigureFactory.generateFigure(testString);
        List<String> testValues = new ArrayList<>(Arrays.asList("1","1","2","2","3","4"));
        Points testPoints = new Points(testValues);
        Triangle testTriangle = new Triangle(testPoints);
        assertThat(testTriangle).isEqualTo(testFigure);
    }

    @Test
    void 사각형_생성_테스트() {
        String testString = "(0,0)-(3,0)-(3,4)-(0,4)";
        Figure testFigure = FigureFactory.generateFigure(testString);
        List<String> testValues = new ArrayList<>(Arrays.asList("0","0","0","4","3","0","3","4"));
        Points testPoints = new Points(testValues);
        Rectangle testRectangle = new Rectangle(testPoints);
        assertThat(testRectangle).isEqualTo(testFigure);
    }

    @Test
    void 중복된_좌표_유효성_테스트() {
        String testString = "(1,1)-(1,1)";
        assertThrows(IllegalArgumentException.class, ()-> FigureFactory.generateFigure(testString));
    }

    @Test
    void 직사각형_아닌_네점_유효성_테스트() {
        String testString = "(1,1)-(1,2)-(3,4)-(2,5)";
        assertThrows(IllegalArgumentException.class, ()-> FigureFactory.generateFigure(testString));
    }

    @Test
    void 세점이_일직선_위에_있을때_테스트() {
        String testString = "(1,1)-(2,2)-(3,3)";
        assertThrows(IllegalArgumentException.class, ()-> FigureFactory.generateFigure(testString));
    }

    @Test
    void 한점만_있을_때_테스트() {
        String testString = "(1,1)-(1,1)";
        assertThrows(IllegalArgumentException.class, ()-> FigureFactory.generateFigure(testString));
    }

    @Test
    void 숫자_범위테스트() {
        String testString = "(25,25)-(1,1)";
        assertThrows(IllegalArgumentException.class, ()-> FigureFactory.generateFigure(testString));
    }
}
