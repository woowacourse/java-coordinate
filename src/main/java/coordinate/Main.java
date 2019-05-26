package coordinate;

import coordinate.domain.Point;
import coordinate.domain.graph.Coordinates;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Point> points = InputView.inputCoordinate();
		Coordinates board = new Coordinates(points);
		OutputView.showGraph(board.getFigure());
		try {
			OutputView.showArea(board.getFigure());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
