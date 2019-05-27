package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VerticesFactoryTest {
    @Test
    public void 올바른_입력이_발생한_경우() {
        Vertices expected = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 2), new Point(1, 3))));

        assertThat(VerticesFactory.makeVertices("(1,2)-(1,3)").toString()).isEqualTo(expected.toString());
    }

    @Test
    public void 잘못된_입력이_발생한_경우() {
        assertThatThrownBy(() -> {
            VerticesFactory.makeVertices("a(1,2)-(1,3)");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 중복_좌표를_입력한_경우() {
        List<String> coordinates = new ArrayList<>(Arrays.asList("(1,2)", "(1,3)", "(1,2)"));

        assertThatThrownBy(() -> {
            VerticesFactory.makeVertices("(1,2)-(1,3)-(1,2)");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}