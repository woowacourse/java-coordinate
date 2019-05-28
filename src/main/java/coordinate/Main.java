package coordinate;

import coordinate.domain.FigureFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
	public static void main(String[] args) {
		Factory factory = FigureFactory.getInstance();
		Figure figure = factory.create(InputView.inputPoints());
		OutputView.showGraph(figure);
		System.out.println();
		OutputView.showArea(figure);
	}
}
