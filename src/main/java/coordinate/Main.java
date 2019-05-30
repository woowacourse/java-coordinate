package coordinate;

import coordinate.domain.PolygonFigureFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
	public static void main(String[] args) {
		FigureFactory factory = PolygonFigureFactory.getInstance();
		Figure figure = assignFigure(factory);
		OutputView.showGraph(figure);
		System.out.println();
		OutputView.showArea(figure);
	}

	private static Figure assignFigure(FigureFactory factory) {
		try {
			return factory.create(InputView.inputPoints());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return assignFigure(factory);
		}
	}
}
