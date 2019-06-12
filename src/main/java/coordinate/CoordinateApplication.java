package coordinate;

import coordinate.domain.figure.Figure;
import coordinate.domain.figure.FigureFactory;
import coordinate.domain.figure.InvalidAbstractFigureException;
import coordinate.domain.figure.InvalidFigureTypeException;
import coordinate.domain.figure.rectangle.InvalidRectangleException;
import coordinate.domain.figure.triangle.InvalidTriangleException;
import coordinate.domain.point.InvalidPointException;
import coordinate.domain.point.PointGroup;
import coordinate.view.input.InputView;
import coordinate.view.output.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        Figure figure = createFigure();
        OutputView.outputCoordinate(figure);
        OutputView.outputArea(figure);
    }

    private static PointGroup createPointGroup() {
        try {
            return new PointGroup(InputView.inputPoints());
        } catch (InvalidPointException e) {
            System.out.println(e.getMessage());
            return createPointGroup();
        }
    }

    private static Figure createFigure() {
        try {
            return FigureFactory.getFigure(createPointGroup().getPointGroup());
        } catch (InvalidFigureTypeException | InvalidAbstractFigureException
                | InvalidTriangleException | InvalidRectangleException e) {
            System.out.println(e.getMessage());
            return createFigure();
        }
    }
}
