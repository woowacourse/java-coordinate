package coordinate.view;

import coordinate.Figure;
import coordinate.domain.Point;

public class OutputView {
	public static void showGraph(final Figure figure) {
		showHorizontalLines(figure);

		showLInes();
		showBottomNumbers();
	}

	private static void showHorizontalLines(Figure figure) {
		for (int row = 24; row >= 0; row--) {
			System.out.print(String.format("%3s", row));
			System.out.print("|");
			showHorizontalOneLine(figure, row);
			System.out.println();
		}
	}

	private static void showHorizontalOneLine(Figure figure, int row) {
		for (int col = 0; col <= 24; col++) {
			showPoint(figure, row, col);
		}
	}

	private static void showPoint(Figure figure, int row, int col) {
		if (figure.hasPoint(Point.of(col, row))) {
			System.out.print(String.format("%-3s", "* "));
			return;
		}
		System.out.print(String.format("%3s", "   "));
	}

	private static void showLInes() {
		for (int col = 0; col <= 24; col++) {
			System.out.print("----");
		}
		System.out.println();
	}

	private static void showBottomNumbers() {
		System.out.print("  ");
		for (int col = 0; col <= 24; col++) {
			System.out.print(String.format("%3s", col));
		}
		System.out.println();
	}

	public static void showArea(final Figure figure) {
		System.out.println();
		System.out.println(figure.getName() + "는 " + String.format("%.2f", figure.getArea()) + "입니다");
	}
}
