package coordinate.controller;

import coordinate.domain.figure.Figure;
import coordinate.domain.figure.FigureFactory;
import coordinate.domain.point.PointGroup;
import coordinate.util.CoordinateRepresentation;
import coordinate.view.*;

public class CoordinateApplication {
    public static void main(String[] args) {
        Figure figure = createFigure();
        OutputView.printCoordinateResult(figure);
    }

    private static Figure createFigure() {
        try {
            return new FigureFactory().create(createPointGroup());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createFigure();
        }
    }

    private static PointGroup createPointGroup() {
        try {
            return CoordinateRepresentation.convertCoordinatePair(InputView.inputCoordinates());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("좌표값은 정수만 가능합니다");
        }
    }
}
