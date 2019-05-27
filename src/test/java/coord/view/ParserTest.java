package coord.view;

import coord.model.figure.Point;
import coord.model.figure.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {
    @Test
    void parseTest() {
        assertThat(Parser.parseCoordinates("(1,2)-(5, 6)-( 3 ,   4)")).isEqualTo(
                new Points(Arrays.asList(new Point(1, 2), new Point(5, 6), new Point(3, 4)))
        );
    }
}