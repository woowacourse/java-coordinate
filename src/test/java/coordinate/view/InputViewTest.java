package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Points;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    public void 올바른_입력이_발생한_경우() {
        List<String> coordinates = new ArrayList<>(Arrays.asList("(1,2)", "(1,3)"));
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 2), new Point(1, 3)));

        assertThat(InputView.makePoints(coordinates)).isEqualTo(new Points(points));
    }

    @Test
    public void 잘못된_입력이_발생한_경우() {
        List<String> coordinates = new ArrayList<>(Arrays.asList("a(1,2)", "(1,3)"));

        assertThatThrownBy(() -> {
            InputView.makePoints(coordinates);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 중복_좌표를_입력한_경우() {
        List<String> coordinates = new ArrayList<>(Arrays.asList("(1,2)", "(1,3)", "(1,2)"));

        assertThatThrownBy(() -> {
            InputView.makePoints(coordinates);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
