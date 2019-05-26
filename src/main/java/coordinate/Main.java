package coordinate;

import coordinate.domain.Point;
import coordinate.domain.Coordinates;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Point> points = InputView.inputCoordinate();
		Coordinates coordinates = new Coordinates(points);
		OutputView.showGraph(coordinates.getFigure());
		try {
			OutputView.showArea(coordinates.getFigure());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
