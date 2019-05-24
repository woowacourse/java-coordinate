package coordinate;

import coordinate.controller.CoordinateController;
import coordinate.domain.Points;
import coordinate.dto.CoordinateDto;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        Points points = InputView.inputPoints();
        CoordinateDto coordinateDto = CoordinateController.request(points);
        OutputView.printBoard(coordinateDto.getBoard());
        OutputView.printResult(coordinateDto.getShape());
    }
}
