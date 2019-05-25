package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureFactoryTest {

    private Points LinePoints=new Points("(1,1)-(2,2)".split("-"));
    private Points TrianglePoints=new Points("(1,1)-(2,4)-(1,5)".split("-"));
    private Points RectanglePoints=new Points("(1,1)-(1,3)-(2,1)-(2,3)".split("-"));

    @Test
    void Line_생성_테스트(){
        Figure figure=FigureFactory.create(LinePoints);
        assertThat(figure.getClass()).isEqualTo(Line.class);
    }

    @Test
    void Triangle_생성_테스트(){
        Figure figure=FigureFactory.create(TrianglePoints);
        assertThat(figure.getClass()).isEqualTo(Triangle.class);
    }

    @Test
    void Rectangle_생성_테스트(){
        Figure figure=FigureFactory.create(RectanglePoints);
        assertThat(figure.getClass()).isEqualTo(Rectangle.class);
    }

}
