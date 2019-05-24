import coordinate.domain.PointList;
import coordinate.domain.Figure;
import coordinate.domain.FigureFactory;
import coordinate.domain.view.InputView;
import coordinate.domain.view.OutputView;

public class CoordinateCalculator {
    public static void main(String[] args) {
        PointList pointList = InputView.InputPoints();
        OutputView.printPoints(pointList);
        Figure figure;
        try {
            figure = FigureFactory.generateFigure(pointList);
            OutputView.printResult(figure);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
