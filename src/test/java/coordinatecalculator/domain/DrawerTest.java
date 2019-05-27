package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DrawerTest {
    @Test
    void 포인트가_좌표에_정상적으로_찍히는지_테스트() {
        Points points = new Points(Arrays.asList(new Point("1", "1"),new Point("1", "3"), new Point("3", "1"),new Point("3", "3")));
        Drawer drawer = new Drawer(points);
        StringBuilder result = new StringBuilder(
                        "24|                                                \n" +
                        "  |                                                \n" +
                        "22|                                                \n" +
                        "  |                                                \n" +
                        "20|                                                \n" +
                        "  |                                                \n" +
                        "18|                                                \n" +
                        "  |                                                \n" +
                        "16|                                                \n" +
                        "  |                                                \n" +
                        "14|                                                \n" +
                        "  |                                                \n" +
                        "12|                                                \n" +
                        "  |                                                \n" +
                        "10|                                                \n" +
                        "  |                                                \n" +
                        " 8|                                                \n" +
                        "  |                                                \n" +
                        " 6|                                                \n" +
                        "  |                                                \n" +
                        " 4|                                                \n" +
                        "  | *   *                                          \n" +
                        " 2|                                                \n" +
                        "  | *   *                                          \n" +
                        "  +------------------------------------------------\n" +
                        " 0    2   4   6   8  10  12  14  16  18  20  22  24\n");

        StringBuilder actual = new StringBuilder();
        List<StringBuilder> board = drawer.getBoard();

        for (int i = 0; i < board.size(); i++) {
            actual.append(board.get(i));
        }
        assertThat(actual.toString()).isEqualTo(result.toString());
    }
}
