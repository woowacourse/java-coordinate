package coordinatecalculator.view.inputview;

import coordinatecalculator.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointParserTest {
    @Test
    void 올바른_입력() {
        List<Point> answer = Arrays.asList(Point.of(0, 0), Point.of(1, 1));
        assertThat(PointParser.getValidPoints("(0,0)-(1,1)")).isEqualTo(answer);
    }

    @Test
    void 입력이_없는경우() {
        assertThrows(NullPointerException.class, () -> {
            PointParser.getValidPoints("");
        });
    }

    @Test
    void 입력_패턴_불일치() {
        assertThrows(IllegalArgumentException.class, () -> {
            PointParser.getValidPoints("0,0-1,1");
        });
    }

    @Test
    void 좌표가_정수가_아닌_경우() {
        assertThrows(NumberFormatException.class, () -> {
            PointParser.getValidPoints("(0,0)-(1,a)");
        });
    }
}