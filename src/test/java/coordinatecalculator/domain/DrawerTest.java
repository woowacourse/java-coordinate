package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DrawerTest {
    @Test
    void 포인트가_좌표에_정상적으로_찍히는지_테스트() {
        Points points = new Points(Arrays.asList(new Point("1", "1"),new Point("1", "3"), new Point("3", "1"),new Point("3", "3")));
        Drawer drawer = Drawer.newInstance(points);
        String expectedResult =
                        "24|                                                " +
                        "  |                                                " +
                        "22|                                                " +
                        "  |                                                " +
                        "20|                                                " +
                        "  |                                                " +
                        "18|                                                " +
                        "  |                                                " +
                        "16|                                                " +
                        "  |                                                " +
                        "14|                                                " +
                        "  |                                                " +
                        "12|                                                " +
                        "  |                                                " +
                        "10|                                                " +
                        "  |                                                " +
                        " 8|                                                " +
                        "  |                                                " +
                        " 6|                                                " +
                        "  |                                                " +
                        " 4|                                                " +
                        "  | *   *                                          " +
                        " 2|                                                " +
                        "  | *   *                                          " +
                        "  +------------------------------------------------" +
                        " 0    2   4   6   8   10  12  14  16  18  20  22  24 ";

        StringBuilder actual = new StringBuilder();
        List<StringBuilder> board = drawer.getBoard();

        for (StringBuilder row : board) {
            actual.append(row);
        }

        assertThat(actual.toString()).isEqualTo(expectedResult);
    }
}
