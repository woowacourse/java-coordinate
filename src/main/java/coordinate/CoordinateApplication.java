package coordinate;

import coordinate.domain.Points;
import coordinate.dto.CoordinateDto;
import coordinate.service.CoordinateService;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            Points points = InputView.inputPoints();
            CoordinateDto coordinateDto = CoordinateService.request(points);
            OutputView.printBoard(coordinateDto.getBoard());
            OutputView.printResult(coordinateDto.getShape());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }
}
