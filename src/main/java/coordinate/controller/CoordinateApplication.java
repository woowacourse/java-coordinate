package coordinate.controller;

import coordinate.domain.figure.Figure;
import coordinate.domain.figure.FigureFactory;
import coordinate.domain.figure.Line;
import coordinate.domain.nonefigure.PointGroup;
import coordinate.util.CoordinateRepresentation;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        PointGroup points = createCoordinatesGroup();
        Figure figure = FigureFactory.getInstance(points);

        if (figure instanceof Line) {
            OutputView.printCoordinatePlane(points);
            OutputView.printLineLength(figure.size());
            return;
        }

        OutputView.printCoordinatePlane(points);
        OutputView.printArea(figure.toString(), figure.size());
        return;
    }

    private static PointGroup createCoordinatesGroup() {
        try {
            return CoordinateRepresentation.convertCoordinatePair(InputView.inputCoordinates());
        } catch (NumberFormatException e) {
            System.out.println("좌표값은 정수만 가능합니다\n");
            return createCoordinatesGroup();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return createCoordinatesGroup();
        }
    }
}
