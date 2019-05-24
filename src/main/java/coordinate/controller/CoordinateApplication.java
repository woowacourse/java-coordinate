package coordinate.controller;

import coordinate.domain.Figure.Figure;
import coordinate.domain.Figure.FigureFactory;
import coordinate.domain.point.PointGroup;
import coordinate.util.CoordinateRepresentation;
import coordinate.view.*;

public class CoordinateApplication {
    public static void main(String[] args) {
        Figure figure = makeFigure();
        OutputView.printCoordinateResult(figure);
    }

    private static Figure makeFigure() {
        try {
            return createFigure(createPointGroup());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return makeFigure();
        }
    }

    private static PointGroup createPointGroup() {
        try {
            return CoordinateRepresentation.convertCoordinatePair(InputView.inputCoordinates());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("좌표값은 정수만 가능합니다");
        }
    }

    private static Figure createFigure(PointGroup points) {
        try {
            return new FigureFactory().create(points);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
