package coordinate.model;

import coordinate.model.Graph;
import coordinate.model.PointsGenerator;
import coordinate.model.Value;
import coordinate.view.OutputView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValueTest {
    @Test
    void 유효한_값_검증_25_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Value("25"));
    }

    @Test
    void 유효한_값_검증_음수_테스트() {
        Graph graph = new Graph();
        graph.setPosition(PointsGenerator.makePoints("(0,0)-(2,2)-(2,0)-(0,2)"));
        OutputView.printGraph(graph);

        assertThrows(IllegalArgumentException.class, () -> new Value("-1"));
    }
}
