package coordinate;

import coordinate.domain.Figure;
import coordinate.domain.Line;
import coordinate.domain.Points;
import coordinate.domain.generator.FigureFactory;
import coordinate.domain.generator.PointsGenerator;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateApp {
    public static void main(String[] args) {
        Points points = generatePoints();
        if (points.size() == Line.NUMBER_OF_POINTS) {
            Line line = new Line(points);
            OutputView.printResult(line);
        } else {
            Figure figure = FigureFactory.generate(points);
            OutputView.printResult(figure);
        }
    }

    private static Points generatePoints() {
        try {
            return new PointsGenerator(InputView.inputCoordinate()).generate();
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            return generatePoints();
        }
    }
}
