package coordinatecalculator.domain;

import coordinatecalculator.view.inputview.PointParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FigureFactoryTest {

    @Test
    void 입력없음_NULL() {
        assertThrows(NullPointerException.class, () -> {
            FigureFactory.create(new PointGroup(PointParser.getValidPoints("")));
        });
    }

    @Test
    void 라인_생성() {
        assertThat(FigureFactory.create(PointGroupTest.line).getName()).isEqualTo("선");
    }

    @Test
    void 삼각형_생성() {
        assertThat(FigureFactory.create(PointGroupTest.triangle).getName()).isEqualTo("삼각형");
    }

    @Test
    void 사각형_생성() {
        assertThat(FigureFactory.create(PointGroupTest.rectangle).getName()).isEqualTo("사각형");
    }

    @Test
    void 잘못된_입력_생성_X_1() {
        assertThrows(IllegalArgumentException.class, () -> {
            FigureFactory.create(new PointGroup(PointParser.getValidPoints("(0,0)")));
        });
    }

    @Test
    void 잘못된_입력_생성_X_2() {
        assertThrows(IllegalArgumentException.class, () -> {
            FigureFactory.create(new PointGroup(PointParser.getValidPoints("(0,0)-(0,1)-(1,0)-(1,1)-(1,2)")));
        });
    }
}