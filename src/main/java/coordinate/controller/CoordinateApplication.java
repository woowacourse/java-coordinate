package coordinate.controller;

import coordinate.domain.Figure.*;
import coordinate.domain.point.PointGroup;
import coordinate.util.CoordinateRepresentation;
import coordinate.view.*;

public class CoordinateApplication {
    public static void main(String[] args) {
        Figure figure = handlePoints();

        if (figure == null) {
            return;
        }

        OutputView.printFigureResult(figure);
    }

    private static Figure handlePoints() {
        PointGroup points = createCoordinatesGroup();
        Figure figure;
        try {
            figure = createFigure(points);
        } catch (IllegalArgumentException e) {
            return handlePoints();
        }
        OutputView.printCoordinatePlane(points);
        points.getSquaredLengths();

        return figure;
    }

    private static PointGroup createCoordinatesGroup() {
        try {
            return CoordinateRepresentation.convertCoordinatePair(InputView.inputCoordinates());
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage("좌표값은 정수만 가능합니다");
            return createCoordinatesGroup();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createCoordinatesGroup();
        }
    }

    private static Figure createFigure(PointGroup points) {
        try {
            return new FigureFactory().create(points);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw new IllegalArgumentException();
        } catch (IllegalStateException e) {
            return null;
        }
    }
}
