package coordinate;

import coordinate.controller.CoordinateController;
import coordinate.domain.Points;
import coordinate.dto.CoordinateDto;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        try {
            Points points = new Points(InputView.inputPoints());
            CoordinateDto coordinateDto = CoordinateController.request(points);
            OutputView.printBoard(coordinateDto.getBoard());
            OutputView.printResult(coordinateDto.getShape());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            start();
        }
    }
}
