package coordinate;

import coordinate.domain.PolygonFigureFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
	public static void main(String[] args) {
		FigureFactory factory = PolygonFigureFactory.getInstance();
		Figure figure = factory.create(InputView.inputPoints());
		OutputView.showGraph(figure);
		System.out.println();
		OutputView.showArea(figure);
	}
}
