package coordinate;

import coordinate.domain.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;


public class Main {
    private static final String EMPTY = "";
    private static final String CAN_NOT_FIND_FIGURE = "해당하는 도형을 찾을 수 없습니다.";
    private static final PointsFactory pointsFactory = PointsFactory.from(SmallCoordinatePoint::of);

    public static void main(String[] args) {
        Points points = readPoints(EMPTY);
        OutputView.printPoints(points);

        try {
            Figure figure = FigureFactory.createFigure(points);
            OutputView.printMessage(figure);
        } catch (FigureFactory.NotSupportedFigureException e){
            OutputView.printMessage(() -> CAN_NOT_FIND_FIGURE);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(() -> e.getMessage());
        }
    }

    private static Points readPoints(String notifyingMessage) {
        String input = InputView.readPoints(notifyingMessage);
        try {
            return PointParser.parse(input, pointsFactory);
        } catch (OutOfCoordinateException e) {
            return readPoints(e.getMessage());
        }
    }
}
